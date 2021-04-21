# HomeWork 3 
## pfind: parallel text search program using multiprocessing
### 21900814 Hwang SuHwan
--------------------
### Concept of named two named pipe

Use "string" as the type of transfer between worker and manager.
In this "string", various data are distinguished through a space.

##### Task
from Manager to Worker

(string Path) (int Option_Case_sensitive) (int Option_Print_Path) (string Words)...

##### Report
from Worker to Manager

(int Numbe_of_subDir) (string subDir_names) (int Numberof_Found_Files) (int      Numberof_Found_Lines)

--------------------
### MakeFIle
pfind: pfind.c rcv.c	
>gcc -o pfind pfind.c
>gcc -o rcv rcv.c
	
clear: rcv pfind	
>rm *.o  
	
To compile: make pfind
To Runm pfind: ./pfind <option> <dir> <words>

---------------------
### Manager(pfind.c)
1. Create report and task named pipe
2. Stores input values received during execution.
3. Make a string according to the task form.
4. Create a child processor and make it a worker.
5. Open the named pipe.
6. Send the task
7. Loop(Repeat until there are no Dir left.)
>8. Get the report from worker
>9. Save the result of worker
>10. Make string acording to the task form from report subdir name	
11. Print out SUmmary
12. Kill All worker
13. END
-------------------------
### Worker(rcv.c)
1. Open the named pipe

Loop(Unitl Killed)

2. Stires Task values
3. Open dir
4. Loop(Repeat until there are no files left)
>5. Check the Type of Files(SL or Dir or Others)
>>6. if SL ignore
>>7. else if DIR (ignore start with .->to ignore  "."and ".."
>>>7. else save name and count it)
>>8. else (Check is it ASCII,Text or not if it is open)
>>9. find the word, if find->print and save
>>>10. else close
11. Make a String according to the report form
12. send it to report
13. END
