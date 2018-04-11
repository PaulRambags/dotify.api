package org.daisy.braille.utils.api.embosser;

import org.daisy.braille.utils.api.factory.FactoryProperties;

/**
 * Extends {@link FactoryProperties} with embosser specific information.
 * @author Joel Håkansson
 */
public interface EmbosserFactoryProperties extends FactoryProperties {

	/**
	 * Gets the make for this embosser
	 * @return returns the make
	 */
	public String getMake();

	/**
	 * Gets the model for this embosser
	 * @return returns the model
	 */
	public String getModel();

}
