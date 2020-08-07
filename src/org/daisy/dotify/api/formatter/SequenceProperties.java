package org.daisy.dotify.api.formatter;

import java.util.Optional;

/**
 * <p>SequenceProperties stores properties that are specific for a sequence
 * of blocks</p>
 * 
 * <p>The constructor is private, use SequenceProperties.Builder
 * to create new instances.</p>
 * 
 * @author Joel Håkansson 
 */
public class SequenceProperties {
	/**
	 * Provides types of "break before" and "break after" rules for sequences.
	 */
	public enum SequenceBreak {
		/**
		 * The default value. It is like SHEET but leaving pages without content
         * completely blank.
		 */
		AUTO,
        /**
         * Inserts a page break.  If there is a transition from duplex to
         * simplex or visa versa, or the page dimensions don't match, then
         * perform a sheet break. The PAGE value can be used to produce media
         * without blank pages.
         */
        PAGE,
        /**
         * Inserts a sheet break. If this results in a page without content, it
         * is paginated.
         */
        SHEET,
		/**
		 * Inserts a volume break. This applies to text body sequences only.
		 */
		VOLUME
	}
	private final String masterName;
	private final Integer initialPageNumber;
	private final SequenceBreak breakBefore;
	private final SequenceBreak breakAfter;
	private final Optional<String> pageCounterName;
	/**
	 * The Builder is used when creating a SequenceProperites instance 
	 * @author Joel Håkansson
	 */
	public static class Builder {
		//Required parameters
		String masterName;
		
		//Optional parameters
		Integer initialPageNumber = null;
		SequenceBreak breakBefore = SequenceBreak.AUTO;
		SequenceBreak breakAfter = SequenceBreak.AUTO;
		private String pageCounterName = null;
		
		/**
		 * Create a new Builder
		 * @param masterName the master name for SequenceProperties instances 
		 * created using this Builder
		 */
		public Builder(String masterName) {
			this.masterName = masterName;
		}
		
		/**
		 * Set the initialPageNumber for the SequenceProperties instances
		 * created using this Builder
		 * @param value the value
		 * @return returns the Builder
		 */
		public Builder initialPageNumber(int value) {
			initialPageNumber = value;
			return this;
		}
		
		/**
		 * Set the break before property for the sequence.
		 * @param value the break type
		 * @return returns "this" object
		 */
		public Builder breakBefore(SequenceBreak value) {
			this.breakBefore = value;
			return this;
		}
		
		/**
		 * Set the break after property for the sequence.
		 * @param value the break type
		 * @return returns "this" object
		 */
		public Builder breakAfter(SequenceBreak value) {
			this.breakAfter = value;
			return this;
		}
		
		/**
		 * Sets the page counter name for the sequence. When this value is
		 * set, pages in the sequence are counted separately (in other words,
		 * not using the default page counter). Instead, pages are counted
		 * together with other sequences having the same page counter name.
		 * 
		 * @param value the identifier
		 * @return returns "this" object
		 */
		public Builder pageCounterName(String value) {
			this.pageCounterName = value;
			return this;
		}
		
		/**
		 * Build SequenceProperties using the current state of the Builder
		 * @return returns a new SequenceProperties instance
		 */
		public SequenceProperties build() {
			return new SequenceProperties(this);
		}
		
	}

	protected SequenceProperties(Builder builder) {
		this.masterName = builder.masterName;
		this.initialPageNumber = builder.initialPageNumber;
		this.breakBefore = builder.breakBefore;
		this.breakAfter = builder.breakAfter;
		this.pageCounterName = Optional.ofNullable(builder.pageCounterName);
	}

	/**
	 * Get the name for the LayoutMaster
	 * @return returns the name of the LayoutMaster
	 */
	public String getMasterName() {
		return masterName;
	}
	
	/**
	 * Get the initial page number, i.e. the number that the first page in the sequence should have
	 * @return returns the initial page number, or null if no initial page number has been specified
	 */
	public Integer getInitialPageNumber() {
		return initialPageNumber;
	}
	
	/**
	 * Get break before type
	 * @return returns the break before type
	 */
	public SequenceBreak getBreakBeforeType() {
		return breakBefore;
	}

	/**
	 * Get break after type
	 * @return returns the break after type
	 */
	public SequenceBreak getBreakAfterType() {
		return breakAfter;
	}

	/**
	 * Gets the page counter name. If a value is present, page numbers
	 * within this sequence should be counted separately (in other words, 
	 * not using the default page counter). Instead, pages are counted
	 * together with other sequences having the same page counter name.
	 * @return returns the page counter name
	 */
	public Optional<String> getPageCounterName() {
		return pageCounterName;
	}
}