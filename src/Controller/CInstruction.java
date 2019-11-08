package Controller;

import DAL.DInstruction;

import javax.print.attribute.HashDocAttributeSet;

public class CInstruction {

    private static CInstruction instance;

    public DInstruction getDInstruction(){
        return DInstruction.getInstance();
    }
}
