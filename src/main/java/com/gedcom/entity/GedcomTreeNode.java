package com.gedcom.entity;
import java.util.LinkedList;
import java.util.List;
/**
 * GedcomTree representing data.
 * 
 * @author gudapatn
 *
 */
public class GedcomBuildTree {
	
	private String nodeid;
    private String nodeinput;
	private int nodeposition;
    private String nodetag;

    
	private GedcomBuildTree parentNode;
    private List<GedcomBuildTree> nodeList;
    
    public int getNodelevel() {
		return nodelevel;
	}
	public void setNodelevel(int nodelevel) {
		this.nodelevel = nodelevel;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public String getNodetag() {
		return nodetag;
	}

	public void setNodetag(String nodetag) {
		this.nodetag = nodetag;
	}

	public String getNodeinput() {
		return nodeinput;
	}

	public void setNodeinput(String nodeinput) {
		this.nodeinput = nodeinput;
	}



	public GedComTree getParentNode() {
		return parentNode;
	}



	public void setParentNode(GedComTree parentNode) {
		this.parentNode = parentNode;
	}



	public void setNodeList(List<GedComTree> nodeList) {
		this.nodeList = nodeList;
	}


   


   
    
    /**
     * API to add a child to this current node. Linked list is used to maintain
     * the list of children so that retrieval can be done in the added order.
     * 
     * @param node
     *            - node to be added as child
     */
    public void addChild(GedcomBuildTree treenode) {
        if (nodeList == null) {
        	nodeList = new LinkedList<GedcomBuildTree>();
        }
        nodeList.add(treenode);
    }



    public GedcomBuildTree getParent() {
        return parentNode;
    }

    public void setParent(GedcomBuildTree parentNode) {
        this.parentNode = parentNode;
    }

    /**
     * to get the node list.
     * 
     * @return
     */
    public boolean isInputPresent() {
        return nodeinput != null && !nodeinput.isEmpty();
    }
    
    public List<GedcomBuildTree> getNodeList() {
        return nodeList;
    }

    /**
     * API to know whether the current node is a child node.
     * 
     * @return
     */
    public boolean isChildNode() {
        return nodeList == null;
    }
    public boolean isRootNode() {
        return level == Common.ROOT_LEVEL;
    } 
    
    public GedcomBuildTree(int nodelevel, String nodeid, String nodeinput, String nodetag) {
        super();
        this.nodelevel = nodelevel;
        this.nodeid = nodeid;
        this.nodetag = nodetag;
        this.nodeinput = nodeinput;
    }

}

