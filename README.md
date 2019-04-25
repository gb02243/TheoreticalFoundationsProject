# TheoreticalFoundationsProject

To start the program the user has to run main.java

Step 1:
 Once the program has started the user is prompted to enter a file name.
    This file must be a .txt (ex: DFA-New.txt)
    
    The txt file must be formatted as such in order to work properly.
              line 1: alphabet- ex:{0,1}
              line 2: states- ex: {a,b,c,d,e}
              line 3: start state- ex: a
              line 4: accept states- ex: {d,e}
              line 5: transition fn- ex: (a,0)->b
                                         (a,1)->c
                                         etc.
              an examlple text file should look like:
                      {0,1}
                      {a,b,c}
                      a
                      {c}
                      (a,0)->b
                      (a,1)->c
                      (b,0)->a
                      (b,1)->c
                      (c,0)->c
                      (c,1)->c
  
  Step 2:                 
  Once the file is inputed and recognized the user is prompted to enter a string to see if is accepted by the given language.
        Possible outputs will be:
              "String is accepted."
              "String is not accepted"
              "Input contains a character that is not in the alphabet"
              
  Step 3:
  After the input is determined if it is accepted the user than is given the option to enter another string to test
  (will repeat step 2 if yes is choosen).
  
  step 4:
  In order to terminate the program the user must select the no option when asked "Do you have another string to test? (y/n)".
