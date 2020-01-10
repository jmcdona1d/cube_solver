# cube_solver

## Web Application
For a more intuitive experience run you can run the web application to get solving instructions from a cube. To run the web app locally, fork/clone this repository and ensure that you have a recent version of *Maven* and *Node Package Manager* installed.

Open a terminal and navigate to the directory `/Spring_API` and run the command `mvn clean install` to ensure dependencies are installed and then run `mvn spring-boot:run` to launch the backend API. After this is running, open a new terminal and navigate to the directory `/React_GUI` and run the command `npm install` and then run `npm start` to create the frontend web site. If it doesn't automatically open, the web app can be found at the default port `localhost:3000`.

While the main solving algorithm is still being debugged until it works >%95 of the time - please try and demo the project by typing the following values: 

`white = 52122200  red = 01445432 blue = 34213553  green = 20445145 orange = 01413130 yellow = 30102355.`

This will create a cube that the program WILL be able to solve (it does not just statically return a result).

## Java Program

Follow these steps to just run the program in *Java* by navigating to the directory `/Java`

This is an application that can solve a Rubik's cube for you using command line inputs.
To use the application, modify the `main` method's `cube.setSide()` lines to copy the state from your actual Rubik's Cube to a Java object one.
The first int inputted to `setSide()` represents the face colour (the colour of the middle square on the face).
The next 8 ints represent the rest of the square colours starting from the top left and moving to the right and then downward - skipping the middle. The diagram at the bottom of the file shows the correct order of this for each face as they are all oriented differently.

Colour mapping to ints is as follows:

- 0 = white
- 1 = red
- 2 = blue
- 3 = green
- 4 = orange
- 5 = yellow

After creating the cube object, the `solveCube()` method gets run on it which prints the list of moves that you can do to return your Rubik's cube to a solved state.

![Numbered Diagram](https://github.com/jmcdona1d/cube_solver/blob/master/Resources/Numbered_Net_Good.png "Logo Title Text")
