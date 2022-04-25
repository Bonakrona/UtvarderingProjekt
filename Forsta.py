from logging.handlers import BaseRotatingHandler

from quicksort import printArr, quick, partition

#search_word_count = input('Enter the word')
file = open('skriv.txt','r', encoding='utf8')
new_dict=dict()
read_data = file.read()
split_data = read_data.split()
stripped_data = split_data.strip()
for line in stripped_data:
    if line in new_dict.keys():
        new_dict[line] = int(new_dict.get(line))+1
    else: new_dict[line] = 1
print(new_dict)




quick(a, 0, len(a)-1)  
print("\nAfter sorting array elements are - ")  
printArr(a)  

#
#word_count = read_data.lower().count(search_word_count)
#print(f"The word '{search_word_count}' appeard {word_count} times.")
