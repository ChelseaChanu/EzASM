package com.ezasm.parsing;

public class LabelArgToken extends RightHandToken {
    private final String label;

    /**
     * Constructs a label based on the text and the line number.
     * Assumes the text has already been validated to be a label.
     * @param text the text of the token.
     */
    public LabelArgToken(String text) {
        super(text);
        this.label = text;
    }

    /**
     * Gets the label's text.
     * @return label's text.
     */
    public String getLabel() {
        return label;
    }
}
