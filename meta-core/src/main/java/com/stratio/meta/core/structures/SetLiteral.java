package com.stratio.meta.core.structures;

import com.stratio.meta.sh.utils.ShUtils;

import java.util.HashSet;
import java.util.Set;

public class SetLiteral extends IdentIntOrLiteral {
    
    public Set<String> literals;

    public SetLiteral() {
        literals = new HashSet<>();
    }
    
    public SetLiteral(String identifier, char operator, Set<String> literals) {
        this();
        this.identifier = identifier;
        this.operator = operator;
        this.literals = literals;
    }
    
    public SetLiteral(Set<String> literals) {
        this();
        this.literals = literals;
    }
       
    public Set<String> getLiterals() {
        return literals;
    }

    public void setLiterals(Set<String> literals) {
        this.literals = literals;
    }        

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(string());        
        sb.append(ShUtils.StringSet(literals, ", "));        
        return sb.toString();
    }
    
}
