import random

def populateFloatSet(Start,End,Size,Samplesize):
    dataSet = set()
    # numbers = round(list(np.random.uniform(Start,End,size=Samplesize)),2)
    numbers = [round(random.uniform(Start,End),2) for _ in range(Samplesize)]
    while(len(dataSet)!= Size):
        dataSet.update(random.sample(numbers,(Size-len(dataSet))))
    return dataSet

def populateIntSet(Start,End,Size):
    dataSet = set()
    numbers = [x for x in range(Start,End)]
    dataSet.update(random.sample(numbers,Size))
    while(len(dataSet)!= Size):
        dataSet.update(random.sample(numbers,(Size-len(dataSet))))
    return dataSet


def populateRepFloatSet(Start,End,Size,Samplesize):
    dataSet = []
    # numbers = round(list(np.random.uniform(Start,End,size=Samplesize)),2)
    numbers = [round(random.uniform(Start,End),2) for _ in range(Samplesize)]
    
    dataSet = random.sample(numbers,int(Size/2))
    j=int(Size/2)+1
    while j < Size:
        dataSet.append(random.choice(dataSet))
        j = j+1
    return dataSet

def populateRepIntSet(Start,End,Size):
    dataSet = []
    numbers = [x for x in range(Start,End)]
    dataSet = random.sample(numbers,int(Size/2))
    j=int(Size/2)+1
    while j < Size:
        dataSet.append(random.choice(dataSet))
        j = j+1

    return dataSet


def sortList(lst):
    newList = list(lst)
    newList.sort()
    return newList

def writeToFile(path, dataSet):
    f= open(path, 'w')
    f.write(",".join([str(i) for i in dataSet]))
    f.close()

for i in range(100,100000,2000):
    randUniPosInt = populateIntSet(1,10*i,i)
    print("trying for" + str(i))
    writeToFile("./random/unique/positive/" + str(i) + ".txt",randUniPosInt)
    randUniNegInt = populateIntSet(-10*i,0,i)
    writeToFile("./random/unique/negative/" + str(i) + ".txt",randUniNegInt)
    randUniPosNegInt = populateIntSet(-10*i,10*i,i)
    writeToFile("./random/unique/mix/" + str(i) + ".txt",randUniPosNegInt)
    randUniPosNegFlt = populateFloatSet(-1*i,i,i,i*10)
    writeToFile("./random/unique/float/" + str(i) + ".txt",randUniPosNegFlt)

    randUniPosInt = populateRepIntSet(1,10*i,i)
    writeToFile("./random/repeative/positive/" + str(i) + ".txt",randUniPosInt)
    randUniNegInt = populateRepIntSet(-10*i,0,i)
    writeToFile("./random/repeative/negative/" + str(i) + ".txt",randUniNegInt)
    randUniPosNegInt = populateRepIntSet(-10*i,10*i,i)
    writeToFile("./random/repeative/mix/" + str(i) + ".txt",randUniPosNegInt)
    randUniPosNegFlt = populateRepFloatSet(-1*i,i,i,i*10)
    writeToFile("./random/repeative/float/" + str(i) + ".txt",randUniPosNegFlt)

    sortedUniPosInt = sortList(populateIntSet(1,10*i,i))
    writeToFile("./sorted/unique/positive/" + str(i) + ".txt",sortedUniPosInt)
    sortedUniNegInt = sortList(populateIntSet(-10*i,0,i))
    writeToFile("./sorted/unique/negative/" + str(i) + ".txt",sortedUniNegInt)
    sortedUniPosNegInt = sortList(populateIntSet(-10*i,10*i,i))
    writeToFile("./sorted/unique/mix/" + str(i) + ".txt",sortedUniPosNegInt)
    sortedUniPosNegFlt = sortList(populateFloatSet(-1*i,i,i,i*10))
    writeToFile("./sorted/unique/float/" + str(i) + ".txt",sortedUniPosNegFlt)

    sortedUniPosInt = sortList(populateRepIntSet(1,10*i,i))
    writeToFile("./sorted/repeative/positive/" + str(i) + ".txt",sortedUniPosInt)
    sortedUniNegInt = sortList(populateRepIntSet(-10*i,0,i))
    writeToFile("./sorted/repeative/negative/" + str(i) + ".txt",sortedUniNegInt)
    sortedUniPosNegInt = sortList(populateRepIntSet(-10*i,10*i,i))
    writeToFile("./sorted/repeative/mix/" + str(i) + ".txt",sortedUniPosNegInt)
    sortedUniPosNegFlt = sortList(populateRepFloatSet(-1*i,i,i,i*10))
    writeToFile("./sorted/repeative/float/" + str(i) + ".txt",sortedUniPosNegFlt)
