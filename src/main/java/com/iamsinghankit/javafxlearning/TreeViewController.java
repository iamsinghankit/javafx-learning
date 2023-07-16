package com.iamsinghankit.javafxlearning;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class TreeViewController implements Initializable {
    @FXML
    private TreeView<String> myTreeview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> rootItem = new TreeItem<>("Files",new ImageView(new Image("/folder.png",15,15,true,true)));

        TreeItem<String> branchItem1 = new TreeItem<>("Picture");
        TreeItem<String> branchItem2 = new TreeItem<>("Video");
        TreeItem<String> branchItem3 = new TreeItem<>("Music");

        TreeItem<String> leafItem1 = new TreeItem<>("Picture1");
        TreeItem<String> leafItem2 = new TreeItem<>("Video1");
        TreeItem<String> leafItem3 = new TreeItem<>("Picture2");
        TreeItem<String> leafItem4 = new TreeItem<>("Video2");
        TreeItem<String> leafItem5 = new TreeItem<>("Music1");
        TreeItem<String> leafItem6 = new TreeItem<>("Music2");

        branchItem1.getChildren().addAll(leafItem1, leafItem2);
        branchItem2.getChildren().addAll(leafItem3, leafItem4);
        branchItem3.getChildren().addAll(leafItem5, leafItem6);
        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);

//        myTreeview.setShowRoot(false);
        myTreeview.setRoot(rootItem);
    }

    public void selectItem() {
        TreeItem<String> selectedItem = myTreeview.getSelectionModel().getSelectedItem();
        if (selectedItem != null)
            System.out.println(selectedItem.getValue());
    }
}
