
package com.example.aaron.mapademisteriosdorecife.entity;
import java.io.Serializable;
import java.util.Calendar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Assombracao implements Serializable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("coords")
    @Expose
    private Coords coords;
    @SerializedName("local")
    @Expose
    private String local;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("localCurto")
    @Expose
    private String localCurto;
    @SerializedName("descricao")
    @Expose
    private String descricao;
    @SerializedName("epoca")
    @Expose
    private String epoca;
    @SerializedName("range")
    @Expose
    private int range;
    @SerializedName("img")
    @Expose
    private Object img;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("tipo")
    @Expose
    private String tipo;

    private Calendar time;
    private final static long serialVersionUID = -5338075323011207683L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocalCurto() {
        return localCurto;
    }

    public void setLocalCurto(String localCurto) {
        this.localCurto = localCurto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Object getImg() {
        return img;
    }

    public void setImg(Object img) {
        this.img = img;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Assombracao{" +
                "nome=" + nome +
                "id=" + id +
                ", coords=" + coords +
                ", local='" + local + '\'' +
                ", localCurto='" + localCurto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", epoca='" + epoca + '\'' +
                ", range=" + range +
                ", img=" + img +
                ", status=" + status +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
