package com.example.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
   /*  List<Imovel> imoveis = new ArrayList<>();
    AtomicLong proximoID = new AtomicLong();


    public List<Imovel> findAll(){
        return imoveis;
    }

    public Imovel save(Imovel imovel){
        if(imovel.getID() == null){
            imovel.setId(proximoID.incrementAndGet());
            imoveis.add(imovel);
        }
        else{
            for(int i = 0; i < imoveis.size(); i++){
                if(imoveis.get(i).getID().equals(imovel)){
                    imoveis.set(i, imovel);
                    break;
                }
            }
        }
         return imovel;
    }

    public Imovel deleteById(Imovel imovel){
        imoveis.removeIf(imoveis -> imoveis.getID().equals(imovel));

        return imovel;
    }

    public Imovel findById(Long id){
        for(Imovel imovel:imoveis){
            if(imovel.getID().equals(id)){
                return imovel;
            }
        }
        return null;
    }*/
}
