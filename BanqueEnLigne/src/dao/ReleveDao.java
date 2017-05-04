package dao;


import java.util.List;

import dto.*;

public interface ReleveDao {
 List <Releve> FindReleveDuMois(int idClient,int idCompte, int mois);
}
