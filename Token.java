// Token class to store lexeme and token type

class Token {
    private String lexeme;
    private TokenType tokenType;

    public Token(String lexeme, TokenType tokenType) {
        this.lexeme = lexeme;
        this.tokenType = tokenType;
    }

    public String getLexeme() {
        return lexeme;
    }
    public TokenType getType() {
        return tokenType;

    }

    @Override
    public String toString() {
        return String.format("Token[lexeme='%s', tokenType='%s']", lexeme, tokenType);
    }

}