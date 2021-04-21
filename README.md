# HomeWork 3 
## pfind: parallel text search program using multiprocessing
### 21900814 Hwang SuHwan
--------------------
### Concept of named two named pipe
'
Use "string" as the type of transfer between worker and manager.
In this "string", various data are distinguished through a space.
'
##### Task
from Manager to Worker
[string Path] [int Option_Case_sensitive] [int Option_Print_Path] [string Words]...
##### Report
from Worker to Manager
[int Numbe_of_subDir] [string subDir_names] [int Numberof_Found_Files] [int Numberof_Found_Lines]
--------------------
### MakeFIle
pfind: pfind.c rcv.c
	gcc -o pfind pfind.c
	gcc -o rcv rcv.c
clear: rcv pfind
	rm *.o
  
 To compile: make pfind
 To Runm pfind: ./pfind <option> <dir> <words>
---------------------
  ### Manager(pfind.c)

 
