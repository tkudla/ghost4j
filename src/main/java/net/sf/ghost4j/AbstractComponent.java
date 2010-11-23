/*
 * Ghost4J: a Java wrapper for Ghostscript API.
 *
 * Distributable under LGPL license.
 * See terms of license at http://www.gnu.org/licenses/lgpl.html.
 */
package net.sf.ghost4j;

import net.sf.ghost4j.document.Document;
import net.sf.ghost4j.document.DocumentException;

/**
 * Abstract component implementation.
 * Contains methods that are common to the different component types (converter, analyzer, modifier ...)
 * @author Gilles Grousset (gi.grousset@gmail.com)
 */
public abstract class AbstractComponent {

	/**
     * Classes of Document supported by the converter.
     */
    protected Class[] supportedDocumentClasses;

    /**
     * Assert a given document instance is supported by the converter
     * @param document
     * @throws DocumentException When document is not supported
     */
    protected void assertDocumentSupported(Document document) throws DocumentException {

        if (supportedDocumentClasses != null) {

            for (Class clazz : supportedDocumentClasses) {
                if (clazz.getName().equals(document.getClass().getName())) {
                    //supported
                    return;
                }
            }

            //document not supported
            throw new DocumentException("Documents of class " + document.getClass().getName() + " are not supported by the converter");
        }
    }
    
}