//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Proje.DBModel
{
    using System;
    using System.Collections.Generic;
    
    public partial class Odeme
    {
        public int OdemeID { get; set; }
        public Nullable<int> KrediKartNo { get; set; }
        public Nullable<int> ParaID { get; set; }
        public Nullable<decimal> Tutar___ { get; set; }
        public Nullable<System.DateTime> Tarih { get; set; }
    
        public virtual AlımSatımGecmisi AlımSatımGecmisi { get; set; }
        public virtual ParaTürleri ParaTürleri { get; set; }
    }
}
