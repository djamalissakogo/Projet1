package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    String code;
    int pos=0;
    ArrayList<Token> tokenList=new ArrayList<>();

    public Lexer(String code) {
        this.code = code;
    }
    public ArrayList<Token> analyze(){
        while(findTokens()){}
        for (Token token : tokenList)
            if (!(token.value.equals(" ") || token.value.equals("\\r")))
                System.out.println(token.type.typeName + " " + token.value + " " + token.pos);
        return this.tokenList;
    }
    public boolean findTokens(){
        TokenType[] tokenTypes=TokenType.tokenTypeList;
        if(this.pos>=code.length())
            return false;
        for (int i=0;i<tokenTypes.length;i++){
            TokenType tokenType=tokenTypes[i];
            String regex=tokenType.reg;
            Matcher matcher=Pattern.compile(regex).matcher(code);
            if(matcher.find(this.pos)&&matcher.start()==this.pos)
            {
                boolean is_new=true;
                String result=this.code.substring(this.pos,this.pos+matcher.group().length());
                Token token = new Token(tokenType, result, this.pos);
                for(int j=0;j<tokenList.size();j++)
                {
                    if (tokenList.get(j).value.equals(token.value)&&tokenList.get(j).pos==token.pos)
                    {
                        is_new=false;
                        break;
                    }
                }
                if (is_new) {
                    this.pos += result.length();
                    if(token.type!=TokenType.tokenTypeList[3]&&token.type!=TokenType.tokenTypeList[2]&&token.type!=TokenType.tokenTypeList[1])
                        tokenList.add(token);
                }
                return true;
            }
        }
        throw new Error("Error on pos: "+this.pos);
    }

}
