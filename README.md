NOTE: This program is minimally functional and requires running the Java file in some type of java programming software (e.g. Eclipse or JGRASP).

My first attempt at writing a program in Java.  This is primarily a basic exercise for me to practice Java, while producing (eventually) a concise, useable program to count organisms, generate basic statistics and write the data to a file.


Currently, the program is just written in a singular, main method.  Will eventually encapsulate aspects of the program in sub-methods and/or classes.

Program is designed to allow the user to easily count (and, eventually, record count data) cells/larvae in wells of
culture plates.

Current functionality:
- Set maximum number of cells to count
- Counting cells
- Display remaining number of cells after a single counting session
- Enter number of replicates for each sample (well)
- Basic statistics on counts (running average, standard deviation) within replicates and/or across wells.

Future features:
The user should be able to just download and run the .jar file on any platform (currently not tested).  However, the user may have to associate the .jar file type with the Java installation on their system.

To run (Linux - Ubuntu):
1. Download the .jar file.
2. Start Terminal.
3. Navigate to the directory containing the .jar file you just downloaded.
4. Type: java -jar <filename>.jar

- Write data to file
- Enter number of samples (wells) to be counted
- Enter number of replicates for each sample (well)
- Basic statistics on counts (running average, standard deviation) within replicates and/or across wells.

