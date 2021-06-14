#include<iostream>
#include<algorithm>
using namespace std;
typedef struct {
    int w;
    int v;
    double avg;
}P;
bool cmp(P a, P b) {
    return a.avg > b.avg;
}
int main() {
    P* p;
    int n, i, m;//n 物品个数 m背包容量
    while (cin >> n >> m) {
        p = new P[n];
        for (i = 0; i < n; i++) {
            cin >> p[i].w >> p[i].v;
            p[i].avg = p[i].v / p[i].w * 1.0;
        }
        sort(p, p + n, cmp);
        int maxvalue = 0;
        for (i = 0; i < n; i++) {
            if (p[i].w <= m) {
                m -= p[i].w;
                maxvalue += p[i].v;
            }
            else {
                break;
            }
        }
        cout << maxvalue << endl;
    }
    return 0;
}