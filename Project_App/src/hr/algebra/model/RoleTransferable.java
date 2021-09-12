/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author lcabraja
 */
public class RoleTransferable implements Transferable {

    public static final DataFlavor ROLE_FLAVOR = new DataFlavor(Role.class, "Role");
    private static final DataFlavor[] SUPPORTED_FLAVORS = {ROLE_FLAVOR};

    private final Role role;

    public RoleTransferable(Role role) {
        this.role = role;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(ROLE_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return role;
        }
        throw new UnsupportedFlavorException(flavor);
    }
}
