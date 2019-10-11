package DragAndDropDesktopUI;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;


@SuppressWarnings("serial")
public class DragAndDropLabel extends javax.swing.JLabel implements DragGestureListener, DragSourceListener {
	
	DragSource dragSource;
	
	public DragAndDropLabel(String text) {
		setText(text);
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		System.out.println("Drag enter");
	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		System.out.println("Drag over");
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		System.out.println("Drag action changed");
	}

	@Override
	public void dragExit(DragSourceEvent dse) {
		// TODO Auto-generated method stub
		System.out.println("Drag exit");
	}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		// TODO Auto-generated method stub
		System.out.println("Drag drop end");
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		// TODO Auto-generated method stub
		System.out.println("Drag gesture recognized");
		Transferable transferable = new StringSelection(getText());
		dragSource.startDrag(dge, DragSource.DefaultCopyDrop, transferable, this);
	}
}
