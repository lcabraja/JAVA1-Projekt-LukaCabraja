/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.user;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Movie;
import hr.algebra.model.MovieTableModel;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author lcabraja
 */
public class MovieCRUD extends javax.swing.JPanel implements Crudable, Refreshable {

    /**
     * Creates new form MovieCRUD
     */
    public MovieCRUD() {
        initComponents();
        init();
    }

    private List<JTextComponent> validationFields;
    private List<Integer> validationLengths;
    private List<JLabel> errorLabels;

    private Repository repository;

    private List<String> oldPosters;
    private List<String> newPosters;
    private String lastPoster;
    private Movie lastMovie = null;
    private MovieTableModel movieTableModel;
    private int selectedMovieId;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbMovies = new javax.swing.JTable();
        lbIDMovie = new javax.swing.JLabel();
        lbErrIDMovie = new javax.swing.JLabel();
        tfIDMovie = new javax.swing.JTextField();
        lbTitle = new javax.swing.JLabel();
        lbErrTitle = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        lbOriginalTitle = new javax.swing.JLabel();
        lbErrOriginalTitle = new javax.swing.JLabel();
        tfOriginalTitle = new javax.swing.JTextField();
        lbHTMLDescription = new javax.swing.JLabel();
        lbErrHTMLDescription = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taHTMLDescription = new javax.swing.JTextArea();
        lbLength = new javax.swing.JLabel();
        lbErrLength = new javax.swing.JLabel();
        tfLength = new javax.swing.JTextField();
        lbGenre = new javax.swing.JLabel();
        lbErrGenre = new javax.swing.JLabel();
        tfGenre = new javax.swing.JTextField();
        lbPosterFilePath = new javax.swing.JLabel();
        lbErrPosterFilePath = new javax.swing.JLabel();
        tfPosterFilePath = new javax.swing.JTextField();
        lbTrailerLink = new javax.swing.JLabel();
        lbErrTrailerLink = new javax.swing.JLabel();
        tfTrailerLink = new javax.swing.JTextField();
        lbLink = new javax.swing.JLabel();
        lbErrLink = new javax.swing.JLabel();
        tfLink = new javax.swing.JTextField();
        lbGuid = new javax.swing.JLabel();
        lbErrGuid = new javax.swing.JLabel();
        tfGuid = new javax.swing.JTextField();
        lbStartsPlaying = new javax.swing.JLabel();
        lbErrStartsPlaying = new javax.swing.JLabel();
        tfStartsPlaying = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btChange = new javax.swing.JButton();
        lbPoster = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(751, 477));
        setPreferredSize(new java.awt.Dimension(751, 477));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        tbMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbMovies);

        lbIDMovie.setText("IDMovie");

        lbErrIDMovie.setText("ID");

        tfIDMovie.setText("jTextField1");
        tfIDMovie.setEnabled(false);

        lbTitle.setText("Title");

        lbErrTitle.setText("Title");

        tfTitle.setText("jTextField1");

        lbOriginalTitle.setText("Original Title");

        lbErrOriginalTitle.setText("OriginalTitle");

        tfOriginalTitle.setText("jTextField1");

        lbHTMLDescription.setText("HTML Description");

        lbErrHTMLDescription.setText("HTML");

        taHTMLDescription.setColumns(20);
        taHTMLDescription.setRows(5);
        jScrollPane3.setViewportView(taHTMLDescription);

        lbLength.setText("Length");

        lbErrLength.setText("Length");

        tfLength.setText("jTextField1");

        lbGenre.setText("Genre");

        lbErrGenre.setText("Genre");

        tfGenre.setText("jTextField1");

        lbPosterFilePath.setText("Poster File Path");

        lbErrPosterFilePath.setText("Poster");

        tfPosterFilePath.setText("jTextField1");
        tfPosterFilePath.setEnabled(false);

        lbTrailerLink.setText("Trailer Link");

        lbErrTrailerLink.setText("Trailer");

        tfTrailerLink.setText("jTextField1");

        lbLink.setText("Link");

        lbErrLink.setText("Link");

        tfLink.setText("jTextField1");

        lbGuid.setText("GUID");

        lbErrGuid.setText("Guid");

        tfGuid.setText("jTextField1");

        lbStartsPlaying.setText("Starts Playing");

        lbErrStartsPlaying.setText("StartsPlaying");

        tfStartsPlaying.setText("jTextField1");

        btChange.setText("Change Image");
        btChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangeActionPerformed(evt);
            }
        });

        lbPoster.setMaximumSize(new java.awt.Dimension(226, 325));
        lbPoster.setMinimumSize(new java.awt.Dimension(226, 325));
        lbPoster.setPreferredSize(new java.awt.Dimension(226, 325));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPoster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lbPoster, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btChange)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbTrailerLink, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(tfTrailerLink))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbOriginalTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(tfOriginalTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbLink, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(tfLink))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbGuid, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(tfGuid))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbStartsPlaying, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(tfStartsPlaying))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIDMovie)
                                    .addComponent(tfTitle)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbPosterFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(tfPosterFilePath))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(tfGenre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbLength, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(tfLength))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbHTMLDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIDMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbErrLength)
                            .addComponent(lbErrGenre)
                            .addComponent(lbErrPosterFilePath)
                            .addComponent(lbErrTrailerLink)
                            .addComponent(lbErrLink)
                            .addComponent(lbErrGuid)
                            .addComponent(lbErrStartsPlaying)
                            .addComponent(lbErrTitle)
                            .addComponent(lbErrOriginalTitle)
                            .addComponent(lbErrHTMLDescription)
                            .addComponent(lbErrIDMovie))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbIDMovie)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfIDMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbErrIDMovie))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTitle)
                            .addComponent(lbErrTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOriginalTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbOriginalTitle)
                            .addComponent(lbErrOriginalTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbHTMLDescription)
                                .addComponent(lbErrHTMLDescription))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbErrLength)
                            .addComponent(lbLength))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbErrGenre)
                            .addComponent(lbGenre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPosterFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPosterFilePath)
                            .addComponent(lbErrPosterFilePath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTrailerLink)
                            .addComponent(tfTrailerLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbErrTrailerLink))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLink)
                            .addComponent(lbErrLink))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbGuid)
                            .addComponent(lbErrGuid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfStartsPlaying, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbStartsPlaying)
                            .addComponent(lbErrStartsPlaying)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
        fillFormWithSelectedRow();
        deleteFiles(newPosters);
        newPosters.clear();
        oldPosters.clear();
        lastPoster = null;
    }//GEN-LAST:event_tbMoviesMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        clearPoster();
    }//GEN-LAST:event_formComponentShown

    private void btChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangeActionPerformed
        Optional<File> potentialFile = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (potentialFile.isPresent()) {
            String oldPath = potentialFile.get().getAbsolutePath();
            String ext = oldPath.substring(oldPath.lastIndexOf("."));
            if (ext.length() > 4) {
                ext = "jpg";
            }
            String posterName = UUID.randomUUID() + ext;
            String newPath = "data" + File.separator + posterName;

            try {
                FileUtils.copy(oldPath, newPath);
            } catch (IOException ex) {
                Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
            tfPosterFilePath.setText(newPath);
            setIcon(lbPoster, newPath);
            if (lastPoster == null && lastMovie != null) {
                lastPoster = lastMovie.getPosterFilePath();
            }

            if (lastPoster != null) {
                oldPosters.add(lastPoster);
                lastPoster = newPath;
            }

            newPosters.add(newPath);
        }
    }//GEN-LAST:event_btChangeActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        clearAction();
    }//GEN-LAST:event_formComponentHidden

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChange;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbErrGenre;
    private javax.swing.JLabel lbErrGuid;
    private javax.swing.JLabel lbErrHTMLDescription;
    private javax.swing.JLabel lbErrIDMovie;
    private javax.swing.JLabel lbErrLength;
    private javax.swing.JLabel lbErrLink;
    private javax.swing.JLabel lbErrOriginalTitle;
    private javax.swing.JLabel lbErrPosterFilePath;
    private javax.swing.JLabel lbErrStartsPlaying;
    private javax.swing.JLabel lbErrTitle;
    private javax.swing.JLabel lbErrTrailerLink;
    private javax.swing.JLabel lbGenre;
    private javax.swing.JLabel lbGuid;
    private javax.swing.JLabel lbHTMLDescription;
    private javax.swing.JLabel lbIDMovie;
    private javax.swing.JLabel lbLength;
    private javax.swing.JLabel lbLink;
    private javax.swing.JLabel lbOriginalTitle;
    private javax.swing.JLabel lbPoster;
    private javax.swing.JLabel lbPosterFilePath;
    private javax.swing.JLabel lbStartsPlaying;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTrailerLink;
    private javax.swing.JTextArea taHTMLDescription;
    private javax.swing.JTable tbMovies;
    private javax.swing.JTextField tfGenre;
    private javax.swing.JTextField tfGuid;
    private javax.swing.JTextField tfIDMovie;
    private javax.swing.JTextField tfLength;
    private javax.swing.JTextField tfLink;
    private javax.swing.JTextField tfOriginalTitle;
    private javax.swing.JTextField tfPosterFilePath;
    private javax.swing.JTextField tfStartsPlaying;
    private javax.swing.JTextField tfTitle;
    private javax.swing.JTextField tfTrailerLink;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

    private void init() {
        try {
            initValidation();
            initRepository();
            initTable();
            initFields();
            clearForm();

        } catch (Exception ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfGenre, tfGuid, taHTMLDescription, tfIDMovie, tfLength, tfLink, tfOriginalTitle, tfPosterFilePath, tfStartsPlaying, tfTitle, tfTrailerLink);
        validationLengths = Arrays.asList(64, 128, 4000, -1, -1, 128, 256, 512, -1, 256, 128);
        errorLabels = Arrays.asList(lbErrGenre, lbErrGuid, lbErrHTMLDescription, lbErrIDMovie, lbErrLength, lbErrLink, lbErrOriginalTitle, lbErrPosterFilePath, lbErrStartsPlaying, lbErrTitle, lbErrTrailerLink);
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setAutoCreateRowSorter(true);
        tbMovies.setRowHeight(25);
        movieTableModel = new MovieTableModel(repository.selectMovies());
        tbMovies.setModel(movieTableModel);
    }

    private void initFields() {
        oldPosters = new ArrayList<>();
        newPosters = new ArrayList<>();
        lastPoster = null;
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to load image");
        }
    }

    private void setIcon(JLabel label, String filePath) {
        try {
            label.setIcon(IconUtils.createIcon(filePath, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            try {
                MessageUtils.showErrorMessage("Error", "Unable to load image");
                label.setIcon(IconUtils.createIcon("assets" + File.separator + "no_image.jpeg", label.getWidth(), label.getHeight()));
            } catch (IOException ex1) {
                Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex1);
                label.setIcon(new ImageIcon());
            }
        }
    }

    private boolean formValid() {
        boolean ok = true;
        boolean condition;
        for (int i = 0; i < validationFields.size(); i++) {
            condition = validationLengths.get(i) > 0 ? validationLengths.get(i) >= validationFields.get(i).getText().trim().length() : true;

//            int min = validationFields.get(i).getText().length();
//            min = min > 10 ? 10 : min;
//            System.out.println(validationFields.get(i).getText().substring(0, min) + " | " + validationLengths.get(i) + " >= " + validationFields.get(i).getText().trim().length() + " = " + condition);
            ok &= condition;
            errorLabels.get(i).setText(!condition ? "X" : "");
            if (!ok) {
            }
        }
        boolean isDateValid = parseDate(tfStartsPlaying.getText().trim()) != null;
        ok &= isDateValid;
        lbErrStartsPlaying.setText(!isDateValid ? "X" : "");

        boolean isLengthValid;
        try {
            Integer.valueOf(tfLength.getText().trim());
            isLengthValid = true;
        } catch (Exception ex) {
            isLengthValid = false;
        }
        ok &= isLengthValid;
        lbErrLength.setText(!isDateValid ? "X" : "");

        return ok;
    }

    @SuppressWarnings("UseSpecificCatch")
    private Date parseDate(String dateString) {
        try {
            String[] dmy = dateString.split("-");
            Date date = Date.valueOf(LocalDateTime.of(Integer.valueOf(dmy[0]), Integer.valueOf(dmy[1]), Integer.valueOf(dmy[2]), 0, 0).toLocalDate());
            return date;
        } catch (Exception ex) {
            return null;
        }
    }

    private void clearForm() {
        validationFields.forEach((component) -> {
            component.setText("");
        });
        errorLabels.forEach((component) -> {
            component.setText("");
        });
        clearPoster();
    }

    private void clearPoster() {
        try {
            setIcon(lbPoster, "assets" + File.separator + "no_image.jpeg");
        } catch (Exception e) {
        }
    }

    private void deleteFiles(List<String> files) {
        files.forEach((poster) -> {
            try {
                new File(poster).delete();
            } catch (Exception e) {
            }
        });
        files.clear();
    }

    private void fillFormWithSelectedRow() {
        int selectedRow = tbMovies.getSelectedRow();
        int rowIndex = tbMovies.convertRowIndexToModel(selectedRow);
        selectedMovieId = (int) movieTableModel.getValueAt(rowIndex, 0);
        try {
            Movie movie = repository.selectMovie(selectedMovieId).get();
            if (movie != null && lastMovie != movie) {
                lastMovie = movie;
                fillForm(movie);
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to select movie!");
        }
    }

    private void fillForm(Movie movie) {
        tfGenre.setText(movie.getGenre());
        tfGuid.setText(movie.getGUID());
        taHTMLDescription.setText(movie.getHTMLDescription());
        tfIDMovie.setText(String.valueOf(movie.getIDMovie()));
        tfLength.setText(String.valueOf(movie.getLength()));
        tfLink.setText(movie.getLink());
        tfOriginalTitle.setText(movie.getOriginalTitle());
        tfPosterFilePath.setText(movie.getPosterFilePath());
        tfStartsPlaying.setText(movie.getStartsPlaying().toString());
        tfTitle.setText(movie.getTitle());
        tfTrailerLink.setText(movie.getTrailerLink());
        try {
            setIcon(lbPoster, movie.getPosterFilePath());
        } catch (Exception e) {
            setIcon(lbPoster, "assets" + File.separator + "no_image.jpeg");
            MessageUtils.showErrorMessage("Poster Error", "Could not display movie poster...");
        }
    }

    @Override
    public void clearAction() {
        tbMovies.clearSelection();
        clearForm();
        deleteFiles(newPosters);
        newPosters.clear();
        oldPosters.clear();
        lastPoster = null;
    }

    @Override
    public void createAction() {
        if (formValid()) {
            Movie newMovie = new Movie(
                    -1,
                    tfTitle.getText().trim(),
                    tfOriginalTitle.getText().trim(),
                    taHTMLDescription.getText().trim(),
                    Integer.valueOf(tfLength.getText().trim()),
                    tfGenre.getText().trim(),
                    tfPosterFilePath.getText().trim(),
                    tfTrailerLink.getText().trim(),
                    tfLink.getText().trim(),
                    tfGuid.getText().trim(),
                    parseDate(tfStartsPlaying.getText().trim())
            );
            try {
                repository.createMovie(newMovie);
                refreshData();
                clearForm();

                deleteFiles(oldPosters);
                newPosters.clear();

                tbMovies.setRowSelectionInterval(tbMovies.getRowCount() - 1, tbMovies.getRowCount() - 1);
                fillFormWithSelectedRow();

            } catch (Exception ex) {
                Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
                showDatabaseConnectionError();
            }
        }
    }

    @Override
    public void updateAction() {
        if (formValid()) {
            Movie newMovie = new Movie(
                    lastMovie.getIDMovie(),
                    tfTitle.getText().trim(),
                    tfOriginalTitle.getText().trim(),
                    taHTMLDescription.getText().trim(),
                    Integer.valueOf(tfLength.getText().trim()),
                    tfGenre.getText().trim(),
                    tfPosterFilePath.getText().trim(),
                    tfTrailerLink.getText().trim(),
                    tfLink.getText().trim(),
                    tfGuid.getText().trim(),
                    parseDate(tfStartsPlaying.getText().trim())
            );
            try {
                repository.updateMovie(lastMovie.getIDMovie(), newMovie);
                movieTableModel.setMovies(repository.selectMovies());
                clearForm();

                deleteFiles(oldPosters);
                newPosters.clear();

            } catch (Exception ex) {
                Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
                showDatabaseConnectionError();
            }
        }
    }

    @Override
    public void deleteAction() {
        if (MessageUtils.showConfirmDialog(
                "Delete movie",
                "Do you really want to delete: " + lastMovie.getTitle()) == JOptionPane.YES_OPTION) {
            try {
                repository.deleteMovie(lastMovie.getIDMovie());
                deleteFiles(newPosters);
                refreshData();
            } catch (Exception ex) {
                Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
                showDatabaseConnectionError();
            }
        }
    }

    @Override
    public void refreshData() {
        try {
            movieTableModel.setMovies(repository.selectMovies());
        } catch (Exception ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Database Error", "Could not refresh database...");
        }
    }

    private void showDatabaseConnectionError() {
        MessageUtils.showInformationMessage("Database Error", "Could not connect to database, please try again later...");
    }
}
