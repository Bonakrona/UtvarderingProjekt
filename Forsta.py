<<<<<<< HEAD
from logging.handlers import BaseRotatingHandler




#search_word_count = input('Enter the word')
file = open('skriv.txt','r', encoding='utf8')
new_dict=dict()
read_data = file.read()
split_data = read_data.split()
for line in split_data:
    stripped_line = line.strip()
    if stripped_line in new_dict.keys():
        new_dict[stripped_line] = int(new_dict.get(stripped_line))+1
    else: new_dict[stripped_line] = 1
print(new_dict)

#
#word_count = read_data.lower().count(search_word_count)
#print(f"The word '{search_word_count}' appeard {word_count} times.")
=======
print("hello man hej på  diiiiig man")
if dinMamma is Snygg:
    Banga


for freddi in felix:
    if kyss:
        giftermå
        return
>>>>>>> 794c0a5e68076efa52a9c782f111a91a4cde379d
