from logging.handlers import BaseRotatingHandler
import string
import time






open1 = time.time()
file = open('skriv.txt','r', encoding='utf8')
open2 = time.time()
new_dict=dict()
read1 = time.time()
read_data = file.read()
split1 = time.time()
split_data = read_data.split()
split2 = time.time()
for line in split_data:
    stripped_line = line.strip().lower()
    if stripped_line in new_dict.keys():
        new_dict[stripped_line] = int(new_dict.get(stripped_line))+1
    else: new_dict[stripped_line] = 1
klar2 = time.time()

sort1 = time.time()
sorted_keys = sorted(new_dict, key=new_dict.get, reverse=True)  # [1, 3, 2]
sorted_dict = {}
for w in sorted_keys:
    sorted_dict[w] = new_dict[w]
sort2 = time.time()
top = list(sorted_dict.items())[:20] #gör en lista av dem N (här 20) första elementen i dictionary
tid = ((sort2-open1)*1000)
print(top)
print(tid)
# print("It take" + (string)(open2 - open1) + "seconds to open the file")
# print("It take" + (split1 - read1) + "seconds to read the file")
# print("It take" + (split2 - split1) + "seconds to split the file")
# print("It take" + (split2 - klar2) + "seconds to go through the file")
# print("It take" + (sort2 - sort1) + "seconds to sort the data ")
# print("It take" + (sort2 - open1) + "seconds to execute the file")


#function that consider last element as pivot,   
#place the pivot at its exact position, and place   
#smaller elements to left of pivot and greater   
#elements to right of pivot.   
  
# def partition (a, start, end):  
#     i = (start - 1)  
#     pivot = a[end] # pivot element  
      
#     for j in range(start, end):  
#         # If current element is smaller than or equal to the pivot  
#         if (a[j] <= pivot):  
#             i = i + 1  
#             a[i], a[j] = a[j], a[i]  
      
#     a[i+1], a[end] = a[end], a[i+1]  
  
#     return (i + 1)  
      
# # function to implement quick sort   
# def quick(a, start, end): # a[] = array to be sorted, start = Starting index, end = Ending index      
#     if (start < end):  
#         p = partition(a, start, end) # p is partitioning index  
#         quick(a, start, p - 1)  
#         quick(a, p + 1, end)  
  
          
# def printArr(a): # function to print the array  
#     for i in range(len(a)):  
#         print (a[i], end = " ")  
  

#search_word_count = input('Enter the word')

#quick(a, 0, len(a)-1) 
#print("\nAfter sorting array elements are - ")  
#printArr(a)  

#
#word_count = read_data.lower().count(search_word_count)
#print(f"The word '{search_word_count}' appeard {word_count} times.")
