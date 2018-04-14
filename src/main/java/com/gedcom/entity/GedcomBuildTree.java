package com.gedcom.core;

import com.gedcom.exception.GedcomParserException;

/**
 * Class responsible for creating a tree out of the data provided.
 * 
 * @author ashas
 *
 */
public class GedcomBuildTree {
    private static GedcomBuildTree createTree = null;
    private GedcomTreeNode root = null;
    private GedcomTreeNode presentNode = null;

    private GedcomBuildTree() {
        super();
        root = new GedcomTreeNode(-1, null, null, "");
        presentNode = root;
    }

    public static GedcomBuildTree getGedcomBuildTree() {
        if (createTree == null) {
            createTree = new GedcomBuildTree();
        }
        return createTree;
    }

    /**
     * API to add node into data tree Step 1: When a node comes with level as 0,
     * a new subtree is started from root. Step 2: If the incoming node's level
     * is greater than the current node, then the new node is added as a child
     * to the current node. Step 3: If the incoming node's level is lesser than
     * the current node, then the new node is added as child to the node whose
     * level is one less than new node's level. Step 4: If the incoming and
     * current node has same level, then the new node is added as a child to the
     * parent of the current node itself.
     * 
     * presentNode indicates the last data node added to the tree.
     * 
     * @param node
     * @throws GedcomParserException
     */
    
 

	public void addNode(GedcomTreeNode node) {
        if (node.getLevel() == 0) {
            root.insertChild(node);
            node.setParent(root);
        } else if (presentNode.getLevel() < node.getLevel()) {
			presentNode.insertChild(node);
            node.setParent(presentNode);
        } else if (presentNode.getLevel() > node.getLevel()) {
            GedcomTreeNode n = getNodeWithGivenLevel(node.getLevel() - 1);
            n.insertChild(node);
            node.setParent(n);
        } else if (presentNode.getLevel() == node.getLevel()) {
            presentNode.getParent().insertChild(node);
            node.setParent(presentNode.getParent());
        }
        presentNode = node;
    }

    /**
     * Method to find the node having the given level starting from current node
     * and traversing till its root.
     * 
     * @param referenceNode
     *            - node from which search has to be started
     * @param expectedLevel
     *            - level to be searched for
     * @return
     */
    private GedcomTreeNode getNodeWithGivenLevel	(int index) {
        GedcomTreeNode node = presentNode.getParent();
        while (node != null) {
            if (node.getLevel() <= index) {
                break;
            } else {
                node = node.getParent();
            }
        }
        return node;
    }

    /**
     * API to retrieve the root node
     * 
     * @return
     */
    public GedcomTreeNode getRoot() {
        return root;
    }
}
