package org.daisy.dotify.api.writer;

/**
 * Defines a row of braille.
 * 
 * @author Joel Håkansson
 */
public interface Row {

	/**
	 * Gets the characters 
	 * @return returns the characters
	 */
	public String getChars();

	/**
	 * Gets the row spacing, in rows
	 * @return the row spacing, or null if not set
	 */
	public Float getRowSpacing();

    /**
     * This is an object that can be sent through the Dotify framework. This extra reference
     * is not a part of the official PEF specification and used when the output is not meant for print.
     *
     * A use-case of this could be to have a external reference tag in the OBFL specification and then
     * use it the writer to add information to the rows of the PEF.
     *
     * @return External reference object
     */
	public Object getExternalReference();
}
