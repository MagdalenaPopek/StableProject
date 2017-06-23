package pl.edu.pja.stable.model;

import pl.edu.pja.stable.entity.Competition;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class CompetitionComboBoxModel extends AbstractListModel implements ComboBoxModel {

    /**
     * Lista obiektów Competition
     */
    List<Competition> competitionList = new ArrayList<Competition>();

    /**
     * Lista wyświetlanych Stringów w ComboBoxie
     */
    List<String> competitionStringList = new ArrayList<String>();

    /**
     * Nie dodajemy pierwszego pola "Nowy", tylko faktyczne dane
     */
    boolean onlyCompetitions = false;

    String selection = null;
    int selectIdx = 0;

    public CompetitionComboBoxModel(List<Competition> competitionList) {
        this(competitionList, false);
    }

    public CompetitionComboBoxModel(List<Competition> competitionList, boolean onlyCompetitions) {
        this.onlyCompetitions = onlyCompetitions;
        start(competitionList);
    }

    private void start(List<Competition> competitionList) {

        if (!onlyCompetitions) {
            Competition competition = new Competition();
            competition.setCompName("Nowy");

            selection = competition.getCompName();

            this.competitionList.add(competition);
        }

        this.competitionList.addAll(competitionList);

        /**
         * Tutaj decydujemy co jest wyświetlane i jak w JComboBoxie.
         */
        for (Competition c : this.competitionList) {
            competitionStringList.add(c.getCompName());
        }
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectIdx = competitionStringList.indexOf(anItem);
        selection = (String) anItem;
    }

    @Override
    public int getSize() {
        return competitionList.size();
    }

    @Override
    public Object getElementAt(int index) {
        //System.out.println(index + "->" + clientStringList.get(index));
        return competitionStringList.get(index);
    }

    public Competition getCompetitionAt(int index) {
        return competitionList.get(index);
    }

    public Competition getSelectedCompetition() {
        return competitionList.get(selectIdx);
    }

    public void refresh(List<Competition> competitionList) {
        start(competitionList);
    }

    public void addCompetition(Competition c) {
        competitionList.add(c);
        competitionStringList.add(c.getCompName());

        selectIdx = competitionStringList.size() - 1;
        selection = competitionStringList.get(selectIdx);
    }

}