SET FOREIGN_KEY_CHECKS = 0;

INSERT IGNORE INTO algorithm(ID,ALGORITHM_NAME_ID,ALGORITHM_NAME,ALGORITHM_TYPE, FILE_NAME, FILE_TYPE, FILE_PATH) VALUES 
('1','SSA','Selection Sort Algorithm','sort', 'SelectionSort.java', 'java', 'sort/'),
('2','MSA','Merge Sort Algorithm','sort', 'MergeSort.java', 'java', 'sort/'),
('3','BSA','Bubble Sort Algorithm','sort', 'BubbleSort.java', 'java', 'sort/'),
('4','LSeA','Linear Search Algorithm','search', 'LinearSearch.java', 'java', 'search/'),
('5','BSeA','Binary Search Algorithm','search', 'BinarySearch.java', 'java', 'search/'),
('6','BrKSA','0-1 Knap-Sack Algorithm (Brute-Force)','knapsack', 'BruteForceKanpSack.java', 'java', 'knapsack/'),
('7','GrKSA','0-1 Knap-Sack Algorithm (Greedy)','knapsack', 'GreedyKanpSack.java', 'java', 'knapsack/'),
('8','DyKSA','0-1 Knap-Sack Algorithm (Dynamic)','knapsack', 'DynamicKanpSack.java', 'java', 'knapsack/');

INSERT IGNORE INTO dataset(ID,DATASET_NAME_ID, DATASET_DISPLAY_NAME, FILE_NAME, FILE_PATH, DATA_TYPE) VALUES 
('1', 'RUPI', 'Random and Unique Positive Integers', '*', 'datasets/random/unique/positive', 'int'),
('2', 'RUNI', 'Random and Unique Negative Integers', '*', 'datasets/random/unique/negative', 'int'),
('3', 'RUPI', 'Random and Unique Positive and Negative Integers', '*', 'datasets/random/unique/mix', 'int'),
('4', 'RUF', 'Random and Unique Positive and Negative Floats', '*', 'datasets/random/unique/float', 'float'),
('5', 'RRPI', 'Random and Repeative Positive Integers', '*', 'datasets/random/repeative/positive', 'int'),
('6', 'RRNI', 'Random and Repeative Negative Integers', '*', 'datasets/random/repeative/negative', 'int'),
('7', 'RRMI', 'Random and Repeative Positive and Negative Integers', '*', 'datasets/random/repeative/mix', 'int'),
('8', 'RRF', 'Random and Repeative Positive and Negative Floats', '*', 'datasets/random/repeative/float', 'float'),
('9', 'SUPI', 'Sorted and Unique Positive Integers', '*', 'datasets/sorted/unique/positive', 'int'),
('10', 'SUNI', 'Sorted and Unique Negative Integers', '*', 'datasets/sorted/unique/negative', 'int'),
('11', 'SUMI', 'Sorted and Unique Positive and Negative Integers', '*', 'datasets/sorted/unique/mix', 'int'),
('12', 'SUF', 'Sorted and Unique Positive and Negative Floats', '*', 'datasets/sorted/unique/float', 'float'),
('13', 'SRPI', 'Sorted and Repeative Positive Integers', '*', 'datasets/sorted/repeative/positive', 'int'),
('14', 'SRNI', 'Sorted and Repeative Negative Integers', '*', 'datasets/sorted/repeative/negative', 'int'),
('15', 'SRMI', 'Sorted and Repeative Positive and Negative Integers', '*', 'datasets/sorted/repeative/mix', 'int'),
('16', 'SRF', 'Sorted and Repeative Positive and Negative Floats', '*', 'datasets/sorted/repeative/float', 'float'),
('17', 'UKP', 'Unrelated KnapSack Problem', '*', 'datasets/knapSack/unrelated', 'int'),
('18', 'WCKP', 'Weakly Corelated KnapSack Problem', '*', 'datasets/knapSack/weaklyCorelated', 'int'),
('19', 'SCKP', 'Strongly Corelated KnapSack Problem', '*', 'datasets/knapSack/stronglyCorelated', 'int');

INSERT IGNORE INTO algorithm_dataset_mapping(ID, ALGORITHM_ID, DATASET_ID) VALUES
('1', '1', '1'),
('2', '1', '2'),
('3', '1', '3'),
('4', '1', '4'),
('5', '1', '5'),
('6', '1', '6'),
('7', '1', '7'),
('8', '1', '8'),
('9', '1', '9'),
('10', '1', '10'),
('11', '1', '11'),
('12', '1', '12'),
('13', '1', '13'),
('14', '1', '14'),
('15', '1', '15'),
('16', '1', '16'),
('17', '2', '1'),
('18', '2', '2'),
('19', '2', '3'),
('20', '2', '4'),
('21', '2', '5'),
('22', '2', '6'),
('23', '2', '7'),
('24', '2', '8'),
('25', '2', '9'),
('26', '2', '10'),
('27', '2', '11'),
('28', '2', '12'),
('29', '2', '13'),
('30', '2', '14'),
('31', '2', '15'),
('32', '2', '16'),
('33', '3', '1'),
('341', '3', '2'),
('35', '3', '3'),
('36', '3', '4'),
('37', '3', '5'),
('38', '3', '6'),
('39', '3', '7'),
('40', '3', '8'),
('41', '3', '9'),
('42', '3', '10'),
('43', '3', '11'),
('44', '3', '12'),
('45', '3', '13'),
('46', '3', '14'),
('47', '3', '15'),
('48', '3', '16'),
('49', '4', '9'),
('50', '4', '10'),
('51', '4', '11'),
('52', '4', '12'),
('53', '4', '13'),
('54', '4', '14'),
('55', '4', '15'),
('56', '4', '16'),
('57', '5', '9'),
('58', '5', '10'),
('59', '5', '11'),
('60', '5', '12'),
('61', '5', '13'),
('62', '5', '14'),
('63', '5', '15'),
('64', '5', '16'),
('65', '6', '17'),
('66', '6', '18'),
('67', '6', '19'),
('68', '7', '17'),
('69', '7', '18'),
('70', '7', '19'),
('71', '8', '17'),
('72', '8', '18'),
('73', '8', '19');

SET FOREIGN_KEY_CHECKS = 1;