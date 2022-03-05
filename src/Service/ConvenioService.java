package Service;

import Dao.ConvenioDao;
import Model.Convenio;

import java.util.List;

    public class ConvenioService {

        ConvenioDao convenioDao = new ConvenioDao();

        public void insertConvenio(Convenio convenio){
            convenioDao.insertConvenio(convenio);
        }

        public void updateConvenio(Convenio convenio){
            convenioDao.updateConvenio(convenio);
        }

        public void updateStatusConvenio(Convenio convenio){
            convenioDao.disableConvenio(convenio);
        }

        public List<Convenio> findAllConvenio(){
            return convenioDao.findAllConvenio();
        }

        public Convenio findByIdConvenio(Long id){
            return convenioDao.findByIdConvenio(id);
        }


}
