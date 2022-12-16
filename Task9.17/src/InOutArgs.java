public class InOutArgs {
    private static String inputFile;
    private static String outputFile;


    public void setInputFile(String inputFile){
        InOutArgs.inputFile = inputFile;
    }
    public String getInputFile(){
        return inputFile;
    }
    public void setOutputFile(String outputFile){
        InOutArgs.outputFile = outputFile;
    }
    public String getOutputFile(){
        return outputFile;
    }
}
