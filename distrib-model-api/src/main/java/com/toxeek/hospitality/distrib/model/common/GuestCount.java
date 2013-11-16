package com.toxeek.hospitality.distrib.model.common;

import com.google.common.base.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Collections;

/**
 * GuestCount
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class GuestCount
{
    private final Integer nbPax;

    private final Integer nbAdult;

    @Nonnull
    private final Collection<Integer> childAges;

    public GuestCount( @Nullable Integer nbPax, @Nullable Integer nbAdult, @Nullable Collection<Integer> childAges )
    {
        this.nbPax = nbPax;
        this.nbAdult = nbAdult;
        this.childAges = childAges == null ? Collections.<Integer>emptyList() : childAges;
    }

    @Nonnull
    public Integer getNbPax()
    {
        return nbPax == null ? nbAdult == null ? 0 : nbAdult + childAges.size() : nbPax;
    }

    @Nullable
    public Integer getNbAdult()
    {
        return nbAdult;
    }

    @Nonnull
    public Collection<Integer> getChildAges()
    {
        return childAges;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode( nbPax, nbAdult, childAges );
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null || getClass() != obj.getClass() )
        {
            return false;
        }
        final GuestCount other = (GuestCount) obj;
        return Objects.equal( this.nbPax, other.nbPax ) && Objects.equal( this.nbAdult, other.nbAdult )
            && Objects.equal( this.childAges, other.childAges );
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper( this ).add( "nbPax", nbPax ).add( "nbAdult", nbAdult ).add( "childAges",
                                                                                                   childAges ).toString();
    }
}
