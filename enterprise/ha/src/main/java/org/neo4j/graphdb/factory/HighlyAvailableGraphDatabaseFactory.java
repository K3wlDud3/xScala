/**
 * Copyright (c) 2002-2014 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.graphdb.factory;

import java.util.Arrays;
import java.util.Map;

import org.neo4j.cluster.ClusterSettings;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.ha.HaSettings;
import org.neo4j.kernel.ha.HighlyAvailableGraphDatabase;

/**
 * Factory for HA Neo4j instances.
 */
public class HighlyAvailableGraphDatabaseFactory
    extends GraphDatabaseFactory
{
    public HighlyAvailableGraphDatabaseFactory()
    {
        super();
        settingsClasses = Arrays.<Class<?>>asList(
                GraphDatabaseSettings.class, ClusterSettings.class, HaSettings.class );
    }

    public GraphDatabaseService newHighlyAvailableDatabase( String path )
    {
        return newEmbeddedDatabaseBuilder( path ).newGraphDatabase();
    }

    public GraphDatabaseBuilder newHighlyAvailableDatabaseBuilder( final String path )
    {
        return new GraphDatabaseBuilder(new GraphDatabaseBuilder.DatabaseCreator()
        {
            @Override
            public GraphDatabaseService newDatabase( Map<String, String> config )
            {
                config.put( "ephemeral", "false" );

                return new HighlyAvailableGraphDatabase( path, config, databaseDependencies() );
            }
        } );
    }
}
