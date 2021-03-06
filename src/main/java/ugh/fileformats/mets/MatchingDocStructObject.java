package ugh.fileformats.mets;

import org.kitodo.api.ugh.exceptions.PreferencesException;

/*******************************************************************************
 * ugh.fileformats.mets / MatchingDocStructObject.java
 *
 * Copyright 2010 Center for Retrospective Digitization, Göttingen (GDZ)
 *
 * http://gdz.sub.uni-goettingen.de
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or (at your
 * option) any later version.
 *
 * This Library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

import ugh.dl.DocStructType;
import ugh.dl.Prefs;

/*******************************************************************************
 * <p>
 * Previously inner class to store matching between the METS type-attribute
 * values (for &lt;div&gt; elements) and the internal type names used in
 * DocStructType attributes.
 * </p>
 *
 * @author Stefan Funk
 * @author Robert Sehr
 * @version 2009-11-20
 * @since 2009-05-09
 *
 ******************************************************************************/

public class MatchingDocStructObject {

    private String            metstype        = null;
    private DocStructType    internaltype    = null;

    /***************************************************************************
     * Default constructor.
     **************************************************************************/
    protected MatchingDocStructObject() {
        // None.
    }

    /***************************************************************************
     * @param metstype
     * @param internaltype
     * @throws PreferencesException
     **************************************************************************/
    protected MatchingDocStructObject(Prefs myPreferences, String metstype,
            String internaltype) throws PreferencesException {

        this.setMetstype(metstype);

        DocStructType dstype = myPreferences
                .getDocStrctTypeByName(internaltype);
        if (dstype == null) {
            // Throw exception.
            PreferencesException pe = new PreferencesException(
                    "MatchingDocStructObject: Internal DocStructType with name '"
                            + internaltype + "' is not defined!");
            throw pe;
        }

        setInternaltype(dstype);
    }

    /***************************************************************************
     * @return the internaltype
     **************************************************************************/
    protected DocStructType getInternaltype() {
        return this.internaltype;
    }

    /***************************************************************************
     * @param internaltype
     *            the internaltype to set
     **************************************************************************/
    protected void setInternaltype(DocStructType internaltype) {
        this.internaltype = internaltype;
    }

    /***************************************************************************
     * @return the metstype
     **************************************************************************/
    protected String getMetstype() {
        return this.metstype;
    }

    /***************************************************************************
     * @param metstype
     *            the metstype to set
     **************************************************************************/
    protected void setMetstype(String metstype) {
        this.metstype = metstype;
    }

}
