package main;

/**
 * Created with IntelliJ IDEA.
 * User: raghuveer_n
 * Date: 10/17/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileDiffMain
{
    // Helper method for get the file content
    private static List<String> fileToLines(String filename)
    {
        List<String> lines = new LinkedList<String>();
        String line;
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            while ((line = in.readLine()) != null)
            {
                lines.add(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return lines;
    }

    /*
       Let's take File2 as our benchmark File and compare File1 (aka "testFile") against the benchmark.
     */

    public static void main(String[] args)
    {
        List<String> testFile = fileToLines("File1.txt");
        List<String> benchmarkFile  = fileToLines("File2.txt");

        // Compute diff. Get the Patch object. Patch is the container for computed deltas.
       List<Diff> changes = DiffAlgorithm.diffFileContents(benchmarkFile, testFile);

        System.out.println("File Differences .... \n"+changes);
    }
}


