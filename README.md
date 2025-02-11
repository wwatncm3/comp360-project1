# COMP 360 Programming Languages - Project 1
## Lexical Analyzer and Parser Implementation

### Team Members
- Member 1: Will Walton
- Member 2: Miles Johnson

### Project Description
This project implements a lexical analyzer and parser for a simple programming language defined by BNF grammar. The project is split into two main components:
1. Lexical Analyzer (Complete)
2. Recursive Descent Parser (In Progress)

### Project Structure
```
comp360-project1/
├── LexicalAnalyzer.java   # Lexical analyzer implementation
├── Token.java             # Token class definition
├── TokenType.java         # Token types enumeration
├── sourcecode1.txt        # Test input file 1
└── sourcecode2.txt        # Test input file 2
```

### Lexical Analyzer Features
The lexical analyzer identifies the following token types:
- Keywords: `float`, `while`
- Identifiers: variable names
- Operators: `=`, `*`, `/`, `>=`
- Delimiters: `{`, `}`, `(`, `)`, `;`

### How to Run
1. Clone the repository:
```bash
git clone https://github.com/wwatncm3/comp360-project1.git
cd comp360-project1
```

2. Compile the Java files:
```bash
javac TokenType.java Token.java LexicalAnalyzer.java
```

3. Run the program:
```bash
java LexicalAnalyzer
```

### Sample Output
The program will analyze both source codes and output the tokens found. Example output:
```
Analyzing Source Code 1:
Token[lexeme='float', tokenType='KEYWORD']
Token[lexeme='sample1', tokenType='IDENTIFIER']
...
```

### BNF Grammar
The language is defined by the following BNF grammar:
```
<program> -> <keyword> <ident> () { <declares> <stmts> <loop><stmts>}
<declares> -> <keyword> <ident> ; | <keyword> <ident> ; <declares>
<stmts> -> <assign> ; <stmts> | <assign> ;
<assign> -> <ident> = <expr>
<expr> -> <ident> {*|/} <expr> | <ident>
<loop> -> <keyword> ( <ident > >= 10 )
<keyword> -> float | while
<ident> -> a <ident>| b<ident> ... | z <ident> | ε
```

### (Parser Implementation)
(Implementing...)

### Submission Details
- Due Date: February 23
- Submit to: sdasgupta@aggies.ncat.edu
- Required: Program must execute correctly and follow department programming standards

### License
Academic Project - COMP 360 Programming Languages Spring 2025
