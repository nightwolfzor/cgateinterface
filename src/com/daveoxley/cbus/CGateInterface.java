/**
 *  CGateInterface - A library to allow interaction with Clipsal C-Gate.
 *  Copyright (C) 2008,2009,2012  Dave Oxley <dave@daveoxley.co.uk>.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.daveoxley.cbus;

import java.net.InetAddress;

/**
 *
 * @author Dave Oxley <dave@daveoxley.co.uk>
 */
public final class CGateInterface extends CGateObject
{
    private CGateInterface()
    {
        super(null);
    }

    @Override
    protected String getKey()
    {
        return "";
    }

    @Override
    public CGateObject getCGateObject(String address) throws CGateException {
        throw new UnsupportedOperationException();
    }

    @Override
    String getProjectAddress() {
        throw new UnsupportedOperationException();
    }

    @Override
    String getResponseAddress(boolean id) {
        throw new UnsupportedOperationException();
    }

    /**
     * Connect to a C-Gate server using the supplied cgate_server and cgate_port.
     *
     * @param cgate_server The <code>InetAddress</code> of the C-Gate server
     * @param command_port The command port for the C-Gate server
     * @param event_port The event port for the C-Gate server
     * @param status_change_port The status change port for the C-Gate server
     * @return CGateSession The C-Gate session
     */
    public static CGateSession connect(InetAddress cgate_server, int command_port, int event_port, int status_change_port)
    {
        return new CGateSession(cgate_server, command_port, event_port, status_change_port);
    }

    /**
     * Issue a <code>noop</code> to the C-Gate server.
     *
     * @see <a href="http://www.clipsal.com/cis/downloads/Toolkit/CGateServerGuide_1_0.pdf">
     *      <i>C-Gate Server Guide 4.3.76</i></a>
     * @param cgate_session
     * @throws com.daveoxley.cbus.CGateException
     */
    public static void noop(CGateSession cgate_session) throws CGateException
    {
        cgate_session.sendCommand("noop").handle200();
    }
}
