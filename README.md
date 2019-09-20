# cube_solver

This is an application that can solve a rubik's cube for you using command line inputs. 
To use the application, modify the `main` method's `cube.setSide()` lines. 
The first int inputted to `setSide()` represents the face colour (the colour of the middle square on the face).
The next 8 ints represent the rest of the sqaure colours starting from the top left and moving to the right and then downward - skipping the middle.

Colour mapping to ints is as follows:
- 0 = white
- 1 = red
- 2 = blue
- 3 = green
- 4 = orange
- 5 = yellow

`````
     ___    
    |444|    
    |444|    
    |444|    
 ---------- 
|333|000|222|
|333|000|222|
|333|000|222|
 _________ 
    |111|   
    |111|   
    |111|   
     ---    
    |123|   
    |485|   
    |678|   
     ---  
 `````
