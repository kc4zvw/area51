//(c)2010 Oscar Toledo G.
import java.applet.*;import java.awt.event.*;import java.awt.*;
public class toledo_chess extends Applet implements MouseListener{
int B,i,y,u,b,I[]=new int[411],G=120,l[]={5,3,4,6,2,4,3,5,1,1,1,1,1,1,1,1,9,9,9
,9,9,9,9,9,13,11,12,14,10,12,11,13,0,11,0,34,33,55,94,0,1,2,3,3,2,1,0,-1,1,-10,
10,-11,-9,9,11,10,20,-9,-11,-10,-20,-21,-19,-12,-8,8,12,19,21,53,47,61,51,47,47
};Image[]im;static final int x=10,z=15,M=10000;
public void init(){for(B=i=y=u=b=0;B++<120;)I[B-1]=B%x!=0?B/x%x<2|B%x<2?7:(B/x&
4)!=0?0:l[i++]|16:7;im=new Image[16];for(;b<15;b++)if(b<7|b>8)im[b]=this.
getImage(this.getDocumentBase(),b+".gif");addMouseListener(this);}
public void stop(){removeMouseListener(this);}
public void update(Graphics g){paint(g);}
public void paint(Graphics g){int x,y,c=21,a;boolean n=false;for(y=0;y<320;y+=
40){for(x=0;x<320;x+=40){g.drawImage(im[I[c]&z],x,y,40,40,n?new Color(144,144,
208):new Color(192,192,255),this);if(c==B){g.setColor(new Color(255,255,0));g.
drawRect(x,y,39,39);g.drawRect(x+1,y+1,37,37);}c++;n=!n;}c+=2;n=!n;}}
void Z(){paint(getGraphics());}public void mouseExited(MouseEvent e){}public
void mousePressed(MouseEvent e){}public void mouseClicked(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseReleased(MouseEvent e){int s=e.getX()/40+(e.getY()/40*x+21);i=
(I[s]^y)&z;if(i>8){B=s;Z();}else if(B!=0&&i<9){b=s;i=I[B]&z;if((i&7)==1&(b<29|b
>90))i=14^y;X(0,0,0,21,u,1);B=0;Z();if(y>0){X(0,0,0,21,u,4/*ply*/);X(0,0,0,21,u
,1);B=0;Z();}}}
public String getAppletInfo(){return"Toledo Java Chess by Oscar Toledo G.";}
int X(int w,int c,int h,int e,int S,int s){int t,o,L,E,d,O=e,N=-M*M,K=78-h<<x,p
,g,n,m,A,q,r,C,a=y>0?-x:x;boolean D,J;y^=8;G++;D=w>0||s>0&&s>=h&&X(0,0,0,21,0,0
)>M;do{if((o=I[p=O])>0){q=o&z^y;if(q<7){A=(q--&2)>0?8:4;C=(o&z)!=9?l[69+q]:57;
do{r=I[p+=l[C]];if(w<1|p==w){g=q>0|p+a!=S?0:S;if(r<1&(q>0|A<3||g>0)||(r+1&z^y)>
9&&q>0|A>2){if((r&7)==2){y^=8;I[G--]=O;return K;}m=0;n=o&z;J=true;E=I[p-a]&z;if
(q>0|E!=7)t=n;else{n+=2;t=6^y;}while(n<=t){L=(r>0?l[r&7|32]*9-h-q:0);if(s>0)L+=
(q!=1?l[p/x+37]-l[O/x+37]+l[p%x+38]-l[O%x+38]+o/16*8:(m>0?9:0))+(q<1?l[p%x+38]-
1+((I[p-1]^n)<1?1:0)+((I[p+1]^n)<1?1:0)+l[n&7|32]*9-99+(g>0?99:0)+(A<2?1:0):0)+
((E^y^9)<1?1:0);if(s>h||1<s&s==h&&L>z|D){I[p]=n;I[O]=0;if(m>0){I[g]=I[m];I[m]=0
;}else if(g>0)I[g]=0;L-=X(s>h|D?0:p,L-N,h+1,I[G+1],E=q>0|A>1?0:p,s);if(h<1&s==1
&&B==O&i==n&p==b&L>-M){G--;return u=E;}J=q!=1||A<7||m>0||s<1|D|r>0|o<z||X(0,0,0
,21,0,0)>M;I[O]=o;I[p]=r;if(m>0){I[m]=I[g];I[g]=0;}else if(g>0)I[g]=9^y;}if(L>N
){I[G]=O;if(s>1){if(h>0&&c-L<0){y^=8;G--;return L;}if(h<1){i=n;B=O;b=p;}}N=L;}
if(J)n++;else{g=p;m=p<O?g-3:g+2;if(I[m]<z|I[m+O-p]>0||I[p+=p-O]>0)n++;}}}}}
while(r<1&q>2||((p=O)>0)&&(q>0|A>2|o>z&r<1)&&++C>0&&--A>0);}}if(++O>98)O=20;}
while(e!=O);y^=8;G--;return N!=-M*M&&N>-K+1924|D?N:0;}}
