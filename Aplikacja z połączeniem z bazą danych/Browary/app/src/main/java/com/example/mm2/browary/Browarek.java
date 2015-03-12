package com.example.mm2.browary;

/**
 * Created by Adrian on 2015-03-09.
 */
public class Browarek {
    int _id;
    String _nazwa;
    float _cena;
    String _ekstrakt;
    String _woltarz;
    String _kraj;
    float _ocena;
    String _kod;

    public Browarek() {
    }

    public Browarek(int _id,String _nazwa,float _cena, String _ekstrakt, String _woltarz,String _kraj,float _ocena, String _kod){
        this._id=_id;
        this._nazwa=_nazwa;
        this._cena=_cena;
        this._ekstrakt=_ekstrakt;
        this._woltarz=_woltarz;
        this._kraj=_kraj;
        this._ocena=_ocena;
        this._kod=_kod;
    }
    public Browarek(String _nazwa,float _cena, String _ekstrakt, String _woltarz,float _ocena){
        this._nazwa=_nazwa;
        this._cena=_cena;
        this._ekstrakt=_ekstrakt;
        this._woltarz=_woltarz;
        this._ocena=_ocena;
    }

    public Browarek(String _nazwa) {
        this._nazwa = _nazwa;
    }

    public String get_nazwa() {
        return _nazwa;
    }

    public void set_nazwa(String _nazwa) {
        this._nazwa = _nazwa;
    }

    public float get_ocena() {
        return _ocena;
    }

    public void set_ocena(float _ocena) {
        this._ocena = _ocena;
    }

    public String get_kod() {
        return _kod;
    }

    public void set_kod(String _kod) {
        this._kod = _kod;
    }

    public String get_kraj() {
        return _kraj;
    }

    public void set_kraj(String _kraj) {
        this._kraj = _kraj;
    }

    public String get_woltarz() {
        return _woltarz;
    }

    public void set_woltarz(String _woltarz) {
        this._woltarz = _woltarz;
    }

    public String get_ekstrakt() {
        return _ekstrakt;
    }

    public void set_ekstrakt(String _ekstrakt) {
        this._ekstrakt = _ekstrakt;
    }

    public float get_cena() {
        return _cena;
    }

    public void set_cena(float _cena) {
        this._cena = _cena;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}

