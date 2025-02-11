
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

// Lexical Analyzer class

public class LexicalAnalyzer {
    private String input;
    private int position;
    private List<Token> tokens;
    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList("float","while"));
    private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("=", "*", "/", ">="));
    private static final Set<String> DELIMITERS = new HashSet<>(Arrays.asList("{", "}", "(", ")", ";"));

    public LexicalAnalyzer(String input) {
        this.input = input;
        this.position = 0;
        this.tokens = new ArrayList<>();
    }

    public List<Token> analyze(){
        while (position < input.length()){
            char currentChar = input.charAt(position);

            //Skip whitespace
            if(Character.isWhitespace(currentChar)){
                position++;
                continue;
            }

            //check for delimiters

            if (DELIMITERS.contains(String.valueOf(currentChar))) {
                tokens.add(new Token(String.valueOf(currentChar), TokenType.DELIMITER));
                position++;
                continue;
                
            }

            //check for operators
            if (isOperatorStart(currentChar)){
                String operator = getOperator();
                tokens.add(new Token(operator, TokenType.OPERATOR));
                continue;
            }

            //check for keywords or identifiers
            if (Character.isLetter(currentChar)){
                String word = getWord();
                if (KEYWORDS.contains(word)){
                    tokens.add(new Token(word, TokenType.KEYWORD ));
                } else {
                    tokens.add(new Token(word, TokenType.IDENTIFIER));
                }
                continue;
            }

            //skip unknown characters
            position++;
        }

        tokens.add(new Token("EOF", TokenType.EOF));
        return tokens;
    }

    private boolean isOperatorStart (char c) {
        return c == '=' || c == '*' || c == '/' || c == '>';
    }

    private String getOperator(){
        StringBuilder operator = new StringBuilder();
        while (position < input.length() && isOperatorStart(input.charAt(position))){
            operator.append(input.charAt(position));
            position++;
        }
        String opStr = operator.toString();
        if (!OPERATORS.contains(opStr)){
            //handle invalid operator
            position -= opStr.length()-1;
            opStr = opStr.substring(0,1);
        }
        return opStr;
    }

    private String getWord(){
        StringBuilder word = new StringBuilder();
        while (position < input.length() && 
            (Character.isLetterOrDigit(input.charAt(position)) || input.charAt(position) == '_')){ 
                word.append(input.charAt(position));
                position++;
            
        }
        return word.toString();
    }

    //Main method to test the lexical analyzer
    // In the LexicalAnalyzer class:
public static void main(String[] args) {
    try {
        // Test Source Code 1
        System.out.println("Analyzing Source Code 1:");
        String sourceCode1 = new String(Files.readAllBytes(Paths.get("sourcecode1.txt")));
        LexicalAnalyzer analyzer1 = new LexicalAnalyzer(sourceCode1);
        List<Token> tokens1 = analyzer1.analyze();
        
        System.out.println("Lexical Analysis Results for Source Code 1:");
        for (Token token : tokens1) {
            System.out.println(token);
        }

        // Test Source Code 2
        System.out.println("\nAnalyzing Source Code 2:");
        String sourceCode2 = new String(Files.readAllBytes(Paths.get("sourcecode2.txt")));
        LexicalAnalyzer analyzer2 = new LexicalAnalyzer(sourceCode2);
        List<Token> tokens2 = analyzer2.analyze();
        
        System.out.println("Lexical Analysis Results for Source Code 2:");
        for (Token token : tokens2) {
            System.out.println(token);
        }
    } catch (IOException e) {
        System.err.println("Error reading source files: " + e.getMessage());
    }
}
    
}