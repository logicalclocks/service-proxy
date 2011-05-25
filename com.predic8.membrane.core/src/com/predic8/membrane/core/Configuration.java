/* Copyright 2009 predic8 GmbH, www.predic8.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License. */

package com.predic8.membrane.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import com.predic8.membrane.core.config.AbstractXMLElement;
import com.predic8.membrane.core.config.Format;
import com.predic8.membrane.core.config.GUI;
import com.predic8.membrane.core.config.Proxy;
import com.predic8.membrane.core.config.Rules;
import com.predic8.membrane.core.config.security.Security;
import com.predic8.membrane.core.rules.Rule;

public class Configuration extends AbstractXMLElement {

	public static final String ELEMENT_NAME = "configuration";

	private static final long serialVersionUID = 1L;

	// Control names
	public static final String ADJ_CONT_LENGTH = "auto_adjust_content_length";
	public static final String INDENT_MSG = "indent_message";
	public static final String INDENT_CONFIG = "indent_config";
	public static final String ADJ_HOST_HEADER = "adjust_host_header_field";

	public static final String PROXY_HOST = "proxy_host";
	public static final String PROXY_PORT = "proxy_port";
	public static final String USE_PROXY = "proxy_use";

	public static final String TRACK_EXCHANGE = "autotrack_new_exchanges";

	public static final String KEY_STORE_LOCATION = "keystore location";
	
	public static final String KEY_STORE_PASSWORD = "keystore password";
	
	public static final String TRUST_STORE_LOCATION = "truststore location";
	
	public static final String TRUST_STORE_PASSWORD = "truststore password";
	
	
	public static final String USE_PROXY_AUTH = "use proxy authentification";
	
	public static final String PROXY_AUTH_PASSWORD = "proxy authentification password";
	
	public static final String PROXY_AUTH_USERNAME = "proxy authentification username";
	
	private Collection<Rule> rules = new ArrayList<Rule>();

	public Map<String, Object> props = new HashMap<String, Object>();

	public Configuration() {

	}

	public Map<String, Object> getProps() {
		return props;
	}

	public void setProps(Map<String, Object> props) {
		this.props = props;
	}

	public Collection<Rule> getRules() {
		return rules;
	}

	public void setRules(Collection<Rule> rules) {
		this.rules = rules;
	}

	public void setIndentMessage(boolean status) {
		props.put(INDENT_MSG, status);
	}

	public boolean getIndentMessage() {
		if (props.containsKey(INDENT_MSG)) {
			return (Boolean) props.get(INDENT_MSG);
		}
		return false;
	}
	
	public void setIndentConfig(boolean status) {
		props.put(INDENT_CONFIG, status);
	}

	public boolean getIndentConfig() {
		if (props.containsKey(INDENT_CONFIG)) {
			return (Boolean) props.get(INDENT_CONFIG);
		}
		return false;
	}

	public void setAdjustHostHeader(boolean status) {
		props.put(ADJ_HOST_HEADER, status);
	}

	public void setAdjustContentLength(boolean status) {
		props.put(ADJ_CONT_LENGTH, status);
	}
	
	public boolean getAdjustHostHeader() {
		if (props.containsKey(ADJ_HOST_HEADER)) {
			return (Boolean) props.get(ADJ_HOST_HEADER);
		}
		return true;
	}

	public boolean getAdjustContentLength() {
		if (props.containsKey(ADJ_CONT_LENGTH)) {
			return (Boolean) props.get(ADJ_CONT_LENGTH);
		}
		return false;
	}
	
	public void setTrackExchange(boolean status) {
		props.put(TRACK_EXCHANGE, status);
	}

	public boolean getTrackExchange() {
		if (props.containsKey(TRACK_EXCHANGE)) {			
			return (Boolean) props.get(TRACK_EXCHANGE);
		}
		return false;
	}

	public boolean isUseProxy() {
		if (props.containsKey(USE_PROXY)) {			
			return (Boolean) props.get(USE_PROXY);
		}
		return false;
	}
	
	public boolean isUseProxyAuthentification() {
		if (props.containsKey(USE_PROXY_AUTH)) {			
			return (Boolean) props.get(USE_PROXY_AUTH);
		}
		return false;
	}
	
	public void setUseProxy(boolean status) {
		props.put(USE_PROXY, status);
	}
	
	public void setUseProxyAuthentification(boolean status) {
		props.put(USE_PROXY_AUTH, status);
	}
	
	public String getProxyHost() {
		if (props.containsKey(PROXY_HOST))
			return (String)props.get(PROXY_HOST);
	
		return null;
	}
	
	public String getKeyStoreLocation() {
		if (props.containsKey(KEY_STORE_LOCATION))
			return (String)props.get(KEY_STORE_LOCATION);
	
		return null;
	}
	
	
	public String getTrustStoreLocation() {
		if (props.containsKey(TRUST_STORE_LOCATION))
			return (String)props.get(TRUST_STORE_LOCATION);
	
		return null;
	}
	
	public void setKeyStoreLocation(String location) {
		if (location == null)
			return;
		props.put(KEY_STORE_LOCATION, location);
	}
	
	public void setTrustStoreLocation(String location) {
		if (location == null)
			return;
		props.put(TRUST_STORE_LOCATION, location);
	}
	
	public String getKeyStorePassword() {
		if (props.containsKey(KEY_STORE_PASSWORD))
			return (String)props.get(KEY_STORE_PASSWORD);
	
		return null;
	}
	
	public String getTrustStorePassword() {
		if (props.containsKey(TRUST_STORE_PASSWORD))
			return (String)props.get(TRUST_STORE_PASSWORD);
	
		return null;
	}
	
	public void setKeyStorePassword(String password) {
		if (password == null)
			return;
		props.put(KEY_STORE_PASSWORD, password);
	}
	
	public void setTrustStorePassword(String password) {
		if (password == null)
			return;
		props.put(TRUST_STORE_PASSWORD, password);
	}
	
	public void setProxyAuthentificationPassword(String password) {
		if (password == null)
			return;
		props.put(PROXY_AUTH_PASSWORD, password);
	}
	
	public String getProxyAuthentificationPassword() {
		if (props.containsKey(PROXY_AUTH_PASSWORD))
			return (String)props.get(PROXY_AUTH_PASSWORD);
	
		return null;
	}
	
	public void setProxyAuthentificationUsername(String user) {
		if (user == null)
			return;
		props.put(PROXY_AUTH_USERNAME, user);
	}
	
	public String getProxyAuthentificationUsername() {
		if (props.containsKey(PROXY_AUTH_USERNAME))
			return (String)props.get(PROXY_AUTH_USERNAME);
	
		return null;
	}
	
	public String getProxyPort() {
		if (props.containsKey(PROXY_PORT))
			return (String)props.get(PROXY_PORT);
	
		return null;
	}
	
	public void setProxyHost(String host) {
		if (host == null)
			return;
		props.put(PROXY_HOST, host);
	}
	
	public void setProxyPort(String port) {
		props.put(PROXY_PORT, port);
	}
	
	@Override
	protected void parseChildren(XMLStreamReader token, String child) throws XMLStreamException {
		if (Rules.ELEMENT_NAME.equals(child)) {
			rules = ((Rules) new Rules().parse(token)).getValues();
		} else if (Format.ELEMENT_NAME.equals(child)) {
			props.putAll(((Format) new Format().parse(token)).getValues());
		} else if (GUI.ELEMENT_NAME.equals(child)) {
			props.putAll(((GUI) new GUI().parse(token)).getValues());
		} else if (Proxy.ELEMENT_NAME.equals(child)) {
			props.putAll(((Proxy) new Proxy().parse(token)).getValues());
		} else if (Security.ELEMENT_NAME.equals(child)) {
			Security security = ((Security) new Security().parse(token));
			props.put(KEY_STORE_LOCATION, security.getKeyStoreLocation());
			props.put(TRUST_STORE_LOCATION, security.getTrustStoreLocation());
			
			props.put(KEY_STORE_PASSWORD, security.getKeyStorePassword());
			props.put(TRUST_STORE_PASSWORD, security.getTrustStorePassword());
		} 
 	}

	@Override
	protected String getElementName() {
		return ELEMENT_NAME;
	}
	
	@Override
	public void write(XMLStreamWriter out) throws XMLStreamException {
		out.writeStartDocument(Constants.UTF_8, Constants.XML_VERSION);
		out.writeStartElement(ELEMENT_NAME);
		
		Rules childRules = new Rules();
		childRules.setValues(rules);
		childRules.write(out);
		
		Format childFormat = new Format();
		childFormat.setValues(props);
		childFormat.write(out);
		
		GUI childGui = new GUI();
		childGui.setValues(props);
		childGui.write(out);
		
		Proxy childProxy = new Proxy();
		childProxy.setValues(props);
		childProxy.write(out);
		
		
		Security security = new Security();
		security.setValues(props);
		security.write(out);
		
		out.writeEndElement();
		out.writeEndDocument();
	}

	
	public void copyFields(Configuration config) {
		setAdjustHostHeader(config.getAdjustHostHeader());
		setIndentMessage(config.getIndentMessage());
		setTrackExchange(config.getTrackExchange());
		setUseProxy(config.isUseProxy());
		setProxyHost(config.getProxyHost());
		setProxyPort(config.getProxyPort());
		
		setKeyStoreLocation(config.getKeyStoreLocation());
		setKeyStorePassword(config.getKeyStorePassword());
		
		setTrustStoreLocation(config.getTrustStoreLocation());
		setTrustStorePassword(config.getTrustStorePassword());
		
		setUseProxyAuthentification(config.isUseProxyAuthentification());
		setProxyAuthentificationUsername(config.getProxyAuthentificationUsername());
		setProxyAuthentificationPassword(config.getProxyAuthentificationPassword());
	}
	

	public boolean isKeyStoreAvailable() {
		return getKeyStoreLocation() != null && !"".equals(getKeyStoreLocation().trim()) && getKeyStorePassword() != null;
	}
	
	
	
}