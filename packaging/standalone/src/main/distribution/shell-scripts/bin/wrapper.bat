@echo off
rem Copyright (c) 2002-2011 "Neo Technology,"
rem Network Engine for Objects in Lund AB [http://neotechnology.com]
rem
rem This file is part of Neo4j.
rem
rem Neo4j is free software: you can redistribute it and/or modify
rem it under the terms of the GNU General Public License as published by
rem the Free Software Foundation, either version 3 of the License, or
rem (at your option) any later version.
rem
rem This program is distributed in the hope that it will be useful,
rem but WITHOUT ANY WARRANTY; without even the implied warranty of
rem MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
rem GNU General Public License for more details.
rem
rem You should have received a copy of the GNU General Public License
rem along with this program.  If not, see <http://www.gnu.org/licenses/>.

echo %java_exe% %wrapper_java_options% %wrapper_log_options% -jar %wrapper_jar% %1 %2 %3 %4 %5 %6 %7 %8 %9
%java_exe% %wrapper_java_options% %wrapper_log_options% -jar %wrapper_jar% %1 %2 %3 %4 %5 %6 %7 %8 %9
