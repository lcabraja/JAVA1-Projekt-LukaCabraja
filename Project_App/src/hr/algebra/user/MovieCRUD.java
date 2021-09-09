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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author lcabraja
 */
public class MovieCRUD extends javax.swing.JPanel implements Crudable {

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

        setPreferredSize(new java.awt.Dimension(751, 477));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
        int selectedRow = tbMovies.getSelectedRow();
        int rowIndex = tbMovies.convertRowIndexToModel(selectedRow);
        selectedMovieId = (int) movieTableModel.getValueAt(rowIndex, 0);
        try {
            Movie movie = repository.selectMovie(selectedMovieId).get();
            if (movie != null) {
                lastMovie = movie;
                fillForm(movie);
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to select movie!");
        }    }//GEN-LAST:event_tbMoviesMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        clearForm();
    }//GEN-LAST:event_formComponentShown

    private void btChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangeActionPerformed
        Optional<File> potentialFile = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (potentialFile.isPresent()) {
            String oldPath = potentialFile.get().getAbsolutePath();
            System.out.println(oldPath);
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

            if (lastMovie != null && !lastMovie.getPosterFilePath().trim().isEmpty()) {
                try {
                    File oldImage = new File(lastMovie.getPosterFilePath());
                    oldImage.delete();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btChangeActionPerformed


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

    private void init() {
        try {
            initValidation();
            initRepository();
            initTable();
            clearForm();

        } catch (Exception ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfGenre, tfGuid, taHTMLDescription, tfIDMovie, tfLength, tfLink, tfOriginalTitle, tfPosterFilePath, tfStartsPlaying, tfTitle, tfTrailerLink);
        validationLengths = Arrays.asList(32, 128, 4000, -1, -1, 128, 256, 512, -1, 256, 128);
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

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to upload image");
        }
    }

    private void setIcon(JLabel label, String filePath) {
        try {
            label.setIcon(IconUtils.createIcon(filePath, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(MovieCRUD.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to upload image");
        }
    }

    private boolean formValid() {
        boolean ok = true;
        for (int i = 0; i < validationFields.size(); i++) {
            ok &= validationFields.get(i).getText().trim().length() > validationLengths.get(i);
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
        }
        try {
            String[] dmy = tfStartsPlaying.getText().trim().split("\\.");
            Date date = Date.valueOf(LocalDateTime.of(Integer.valueOf(dmy[2]), Integer.valueOf(dmy[1]), Integer.valueOf(dmy[0]), 0, 0).toLocalDate());
        } catch (NumberFormatException numberFormatException) {
            ok = false;
        }
        return ok;
    }

    private void clearForm() {
        validationFields.forEach((component) -> {
            component.setText("");
        });
        errorLabels.forEach((component) -> {
            component.setText("");
        });
        try {
            setIcon(lbPoster, "assets" + File.separator + "no_image.jpeg");
        } catch (Exception e) {
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
    public void CreateAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
