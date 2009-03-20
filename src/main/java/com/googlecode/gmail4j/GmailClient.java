/*
 * Copyright (c) 2008-2009 Tomas Varaneckas
 * http://www.varaneckas.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.googlecode.gmail4j;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.gmail4j.auth.Credentials;
import com.googlecode.gmail4j.rss.RssGmailClient;

/**
 * Abstract Gmail client.
 * <p>
 * Example use:
 * <p><blockquote><pre>
 *     GmailClient client = new RssGmailClient();
 *     client.setLoginCredentials(new Credentials("user", "pass".toCharArray()));
 *     client.init();
 *     for (GmailMessage message : client.getUnreadMessages()) {
 *         System.out.println(message.getFrom() + ": " + message.getTitle());
 *     }
 * </pre></blockquote>
 * 
 * @see RssGmailClient
 * @see GmailMessage
 * @see Credentials
 * @author Tomas Varaneckas &lt;tomas.varaneckas@gmail.com&gt;
 * @version $Id$
 * @since 0.1
 */
public abstract class GmailClient {

    /**
     * Logger
     */
    protected final Log log = LogFactory.getLog(getClass());
    
    /**
     * Login credentials
     */
    protected Credentials loginCredentials;

    /**
     * Argless constructor for safe extending 
     */
    public GmailClient() {
        super();
    }

    /**
     * Setter for {@link #loginCredentials}
     * 
     * @param loginCredentials Gmail login
     */
    public void setLoginCredentials(final Credentials loginCredentials) {
        this.loginCredentials = loginCredentials;
    }

    /**
     * Wrapper method for setting {@link #loginCredentials}
     * 
     * @param username Gmail username
     * @param password Gmail password
     */
    public void setLoginCredentials(final String username, final char[] password) {
        setLoginCredentials(new Credentials(username, password));
    }
    
    /**
     * Initializes the client.
     */
    public abstract void init();
    
    /**
     * Returns list of unread {@link GmailMessage} objects
     * 
     * @return List of unread messages
     */
    public abstract List<GmailMessage> getUnreadMessages();

}