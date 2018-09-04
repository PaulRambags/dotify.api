/*
 * Braille Utils (C) 2010-2011 Daisy Consortium
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.daisy.braille.utils.api.factory;

import java.io.Serializable;
import java.util.Objects;

/**
 * Provides an abstract class for Factories.
 * @author Joel Håkansson
 *
 */
public abstract class AbstractFactory implements Factory, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3248048759239384586L;
	private final String name;
	private final String desc;
	private final String identifier;

	/**
	 * Creates a new AbstractFactory with the supplied values.
	 * It is currently possible to supply a null identifier, however this will
	 * throw a null pointer exception in future versions.
	 * @param name the factory name
	 * @param desc the factory description
	 * @param identifier the factory identifier
	 */
	public AbstractFactory(String name, String desc, String identifier) {
		this.name = name;
		this.desc = desc;
		this.identifier = Objects.requireNonNull(identifier);
	}

	@Override
	public String getDescription() {
		return desc;
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractFactory [name=" + name + ", desc=" + desc
				+ ", identifier=" + identifier + "]";
	}

}