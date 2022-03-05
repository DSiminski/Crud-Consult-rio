package Service;

import Dao.EspecialidadeDao;
import Model.Especialidade;

import java.util.List;

public class EspecialidadeService {

    EspecialidadeDao especialidadeDao = new EspecialidadeDao();

    public void insertEspecialidade(Especialidade especialidade){
        especialidadeDao.insertEspecialidade(especialidade);
    }

    public void updateEspecialidade(Especialidade especialidade){
        especialidadeDao.updateEspecialidade(especialidade);
    }

    public void disableEspecialidade(Especialidade especialiade){
        especialidadeDao.disableEspecialidade(especialiade);
    }

    public List<Especialidade> findAllEspecialidade(){
        return especialidadeDao.findAllEspecialidade();
    }

    public Especialidade findByIdEspecialidade(Long id){
        return especialidadeDao.findByIdEspecialidade(id);
    }

}

