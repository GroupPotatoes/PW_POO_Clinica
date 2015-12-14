package Module.DBO;


public class PhoneNumber {
    /*
    [id_phone_type] [int] NOT NULL,
	[id_patient] [int] NOT NULL,
	[area_code] [int] NOT NULL,
	[number] [numeric](18, 0) NOT NULL
) 
    */
          
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
        private int idPhoneType;
        private int idPatient;
        private int areaCode;
        private String number;
    
    // </editor-fold>
    
          
    // <editor-fold defaultstate="collapsed" desc="Construction">
        
        public PhoneNumber(int idPhoneType, int idPatient, int areaCode, String number) throws Exception
        {
            this.setIdPhoneType(idPhoneType);
            this.setIdPatient(idPatient);
            this.setAreaCode(areaCode);
            this.setNumber(number);
        }
        
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="Setter">
        
        public void setIdPhoneType(int idPhoneType)throws Exception {
            if(idPhoneType <= 0)
                throw new Exception("ID inválido");
        
            this.idPhoneType = idPhoneType;
        }

        public void setIdPatient(int idPatient)throws Exception {
            if(idPatient <= 0)
                throw new Exception("ID inválido");
        
            this.idPatient = idPatient;
        }

        public void setAreaCode(int areaCode)throws Exception {
            if(areaCode <= 0)
                throw new Exception("AreaCode inválido");
        
            this.areaCode = areaCode;
        }

        public void setNumber(String number) throws Exception {
            
            if(number == null)
                throw new Exception("Number inválido.");
            
            this.number = number;
        }

    // </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="Getter">
    public int getIdPhoneType() {
        return idPhoneType;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }
    
    // </editor-fold>
   
}
