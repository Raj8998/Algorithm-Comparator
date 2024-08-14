let chart = null;
let chart1 = null;
let timeOut = 120000;

async function generateTypes(selectHtmlId) {
    listedItems = `<option value="select">--Select--</option>`;
 let fetchResponse = await fetch('http://localhost:8080/getAlgorithmDetails', { method: "GET", mode: 'cors', headers: { 'Content-Type': 'application/json',}});
    let data = await fetchResponse.json();
    window.localStorage.setItem("apiResponse", JSON.stringify(data));
    const uniqueAlgorithmTypeDisplayNames = [...new Set(data.map(item => item.algorithmTypeDisplayName))];
    for (let i = 0; i < uniqueAlgorithmTypeDisplayNames.length; i++) {
        listedItems += `<option value= "${uniqueAlgorithmTypeDisplayNames[i]}" id=${i}>${uniqueAlgorithmTypeDisplayNames[i]}</option>`;
    }
    if (listedItems != null) {
        $(`#${selectHtmlId}`).html(listedItems);
    }
}

function generateSubTypeListFromType(type, selectHtmlId) {
    listedItems = `<option value="select">--Select--</option>`;
    let allAlgorithms = JSON.parse(localStorage.getItem("apiResponse"));
    if (type === 'select') {
        location.reload();
        return;
    }
    let algoSubTypes = findTypeFromList(type, allAlgorithms);
    for (let i = 0; i < algoSubTypes.length; i++) {
        listedItems += `<option value= "${algoSubTypes[i].algorithmNameID}" id=${algoSubTypes[i].algorithmNameID}>${algoSubTypes[i].algorithmName}</option>`;
    }
    if (listedItems != null) {
        $(`#${selectHtmlId}`).html(listedItems);
    }
}

function findTypeFromList(type, list) {
    let filteredList = [];
    for (let i=0;i<list.length;i++) {
        if (list[i].algorithmTypeDisplayName === type) filteredList.push(list[i]);
    }
    return filteredList;
}

function getDataSetList(selectedAlgo1, selectedAlgo2, selectHtmlId){
    let dataSet1 = getDataSetListForAlgo(selectedAlgo1);
    let dataSet2 = getDataSetListForAlgo(selectedAlgo2);

    let filteredList = [];
    for(let i=0;i<dataSet1.length; i++){
        let isIncluded = false;
        for(let j=0;j<dataSet2.length; j++){
            if(dataSet1[i].dataSetID === dataSet2[i].dataSetID){
                isIncluded = true;
                break;
            }
        }
        if(isIncluded) filteredList.push(dataSet1[i]);
    }

    listedItems = `<option value="select">--Select--</option>`;
    if (selectedAlgo1 === 'select' || selectedAlgo2 === 'select') {
        location.reload();
        return;
    }
    for (let i = 0; i < filteredList.length; i++) {
        listedItems += `<option value= "${filteredList[i].dataSetID}" id=${filteredList[i].dataSetID}>${filteredList[i].dataSetDisplayName}</option>`;
    }
    if (listedItems != null) {
        $(`#${selectHtmlId}`).html(listedItems);
    }
}

function getDataSetListForAlgo(algo){
    let allAlgorithms = JSON.parse(localStorage.getItem("apiResponse"));
    let dataSets = [];
    for(let i=0;i<allAlgorithms.length;i++){
        if(allAlgorithms[i].algorithmNameID === algo){
            dataSets = allAlgorithms[i].usableDataSets;
            break;
        }
    }
    return dataSets;
}


async function SendData(){
    let data;
    let algoSub1Type=$('#algoSub1Types option:selected').val()
    let algoSub2Type=$('#algoSub2Types option:selected').val()
    let dataSetSelect=$('#dataSetSelect option:selected').val()
    
    data = {
        algorithmNameIDs:[algoSub1Type,algoSub2Type], 
        dataSetNameID:dataSetSelect
    }

    let options = {
         method : 'POST', 
         headers: {
            'Content-Type':'application/json'
         },
         mode: 'cors',
         body: JSON.stringify(data)};
    
    let response = await fetch('http://localhost:8080/compareAlgorithms',options);
	let responseJson = await response.json();
    if(response.status == 412) generateStatusBar(responseJson.responseMessage);
    else if(response.ok) 
    {
        if(chart != null) 
        {
            chart.destroy();
            chart = null;
        }
        if(chart1 != null) 
        {
            chart1.destroy();
            chart1 = null;
        }
        generateStatusBar("Request sent successfully.");
        getResult(algoSub1Type,algoSub2Type);
    } else {
        generateStatusBar("Unexpected error occured.");
    }
}

function generateStatusBar(statusMsg){
    $('#snackbar').html(statusMsg);
    $('#snackbar').addClass('show');
    setTimeout(function() {$('#snackbar').removeClass('show').addClass('');}, 3000);
}


function getResult(algo1,algo2)
{
    let allAlgorithms = JSON.parse(localStorage.getItem("apiResponse"));
    let algoName1 = null;
    let algoName2 = null;
    for(let i=0;i<allAlgorithms.length;i++){
        if(algoName1 != null && algoName2 != null) break;
        if(allAlgorithms[i].algorithmNameID === algo1){
            algoName1 = allAlgorithms[i].algorithmName;
        }
        if(allAlgorithms[i].algorithmNameID === algo2){
            algoName2 = allAlgorithms[i].algorithmName;
        }
    }
    let startTime = new Date();
    const wait = setInterval( async function(){
        let options = {
            method: "GET", mode: 'cors', headers: { 'Content-Type': 'application/json',}};
        
        let response = await fetch('http://localhost:8080/getAllResponses',options);
        let responseJson = await response.json();
        if((Number(responseJson["testCases"]) == Object.keys(responseJson["executionTimeMap"][algo1]).length && Number(responseJson["testCases"]) == Object.keys(responseJson["executionTimeMap"][algo2]).length) || new Date() - startTime > timeOut){
            createChart(responseJson["executionTimeMap"][algo1], responseJson["executionTimeMap"][algo2], algoName1, algoName2);
            clearInterval(wait);
            return;
        }
        createChart(responseJson["executionTimeMap"][algo1], responseJson["executionTimeMap"][algo2], algoName1, algoName2);
    }, 1000);
}

function createChart(responseJsonAlgo1, responseJsonAlgo2, algo1, algo2){
    let xValues = Object.keys(responseJsonAlgo1).length >= Object.keys(responseJsonAlgo2).length ? Object.keys(responseJsonAlgo1).map(Number) : Object.keys(responseJsonAlgo2).map(Number);
    let resAlgo1 = [];
    let resAlgo2 = [];
    xValues = xValues.sort(function(a, b){return a - b});
    for (i of xValues)
    {
        if(i.toString() in responseJsonAlgo1){
            resAlgo1.push(Number(responseJsonAlgo1[i.toString()]));
        }
        if(i.toString() in responseJsonAlgo2)
            resAlgo2.push(Number(responseJsonAlgo2[i.toString()]));
    }
    // console.log(xValues);
    if(chart != null){
        chart.data.datasets[0].data = resAlgo1;
        chart.data.datasets[1].data = resAlgo2; 
        chart.data.labels = xValues;
        chart.update(); 
    } else{
        $('#myChartDiv').removeClass("show").addClass("show");
        chart = new Chart("myChart", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [{
            label : `${algo1}`,  
            data: resAlgo1,
            borderColor: "yellow",
            // yAxisID: 'A',
            fill: false
            },{
                label : `${algo2}`,
                data: resAlgo2,
                borderColor: "green",
                // yAxisID: 'B',
                fill: false
                }]
        },
        options: {
            maintainAspectRatio: false,
            legend: {display: true},
            animation: {
                duration: 0
            },           
        }
        });
}
}