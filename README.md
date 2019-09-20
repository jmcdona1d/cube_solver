# cube_solver

This is an application that can solve a rubik's cube for you using command line inputs. 
To use the application, modify the `main` method's `cube.setSide()` lines to copy the state from your actual Rubik's Cube to a Java object one. 
The first int inputted to `setSide()` represents the face colour (the colour of the middle square on the face).
The next 8 ints represent the rest of the sqaure colours starting from the top left and moving to the right and then downward - skipping the middle. The diagram at the bottom of the file shows the correct order of this for each face as they are all oriented differently.

Colour mapping to ints is as follows:
- 0 = white
- 1 = red
- 2 = blue
- 3 = green
- 4 = orange
- 5 = yellow

After creating the cube object, the `solveCube()` method gets run on it which prints the list of moves that you can do to return your Rubik's cube to a solved state.


![Numbered Diagram](https://github.com/jmcdona1d/cube_solver/blob/master/Resources/Numbered_Net_Good.png "Logo Title Text") 
