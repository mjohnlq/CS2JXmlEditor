/*
 Copyright 2015 Mathieu Blond - Ijinus ( mathieu.blond@ijinus.fr )

 This file is part of CS2JXmlEditor.

    CS2JXmlEditor is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CS2JXmlEditor is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with CS2JXmlEditor.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.ijinus.cs2j.xmleditor.javaFXui;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import com.ijinus.cs2j.xmleditor.xml.model.InterfaceRepTemplate;

/**
 * A TabPane a little extended which can be dynamically populated.
 * 
 * @author Mathieu Blond - Ijinus (http://www.ijinus.com/?lang=en)
 *
 */
public class TabTemplateController extends TabPane{

	public static FileTab ACTIVE_TAB;
	
	private MainWindow _mainFrame;	
	
	public TabTemplateController(){
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TabTemplate.fxml"));
		fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
	}
	
	@FXML
	public void initialize(){
	}
	
	public void setMainFrame(MainWindow mainFrame){ _mainFrame = mainFrame; }
	
	public void populate(){
		for(InterfaceRepTemplate file : _mainFrame.getData()){
			FileTab tab = new FileTab(file);
			
			ObservableList<Tab> tabs = this.getTabs();
			tabs.add(tab);
		}

	}
	
	/**
	 * Adds a tab an select it
	 * 
	 * @param newFile
	 */
	public void newTab(InterfaceRepTemplate newFile) {
		this.getTabs().add(new FileTab(newFile));		
		this.getSelectionModel().selectLast();
	}
	
}
