/**
 *  CGateInterface - A library to allow interaction with Clipsal C-Gate.
 *  Copyright (C) 2008  Dave Oxley <dave@daveoxley.co.uk>.
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

import java.util.HashMap;

/**
 *
 * @author Dave Oxley <dave@daveoxley.co.uk>
 */
class Utils
{
    static HashMap<String,String> responseToMap(String cgate_response)
    {
        HashMap<String,String> map = new HashMap<String,String>();
        String resp_array[] = cgate_response.substring(4).split(" ");
        for (String resp : resp_array)
        {
            int index = resp.indexOf("=");
            if (index > -1)
                map.put(resp.substring(0, index), resp.substring(index + 1));
        }
        return map;
    }
}
