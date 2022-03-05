package Service;

import Dao.SecretariaDao;
import Model.Secretaria;

import java.util.List;

public class SecretariaService {

    SecretariaDao secretariaDao = new SecretariaDao();

    public void insertSecretaria(Secretaria secretaria){
        secretariaDao.insertSecretaria(secretaria);
    }

    public void updateSecretaria(Secretaria secretaria){
        secretariaDao.updateSecretaria(secretaria);
    }

    public void updateStatusSecretaria(Secretaria secretaria){
        secretariaDao.disableSecretaria(secretaria);
    }

    public List<Secretaria> findAllSecretaria(){
        return secretariaDao.findAllSecretaria();
    }

    public Secretaria findByIdSecretaria(Long id){
        return secretariaDao.findByIdSecretaria(id);
    }


}
